import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            String url = "rmi://localhost:1099/CriptografiaService";
            
            ServicoCriptografia servico = (ServicoCriptografia) Naming.lookup(url);
            
            System.out.println("Cliente: Serviço encontrado! Conectado ao Servidor.");
            
            int modo;

            do {
                System.out.println("\n----------------------------------");
                System.out.println("DIGITE:");
                System.out.println("1 -> ENCRIPTAR (Cifra César + Inversão)");
                System.out.println("2 -> DECRIPTAR (Inversão + Cifra César Inversa)");
                System.out.println("0 -> SAIR");
                System.out.print(">> ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Digite um número.");
                    scanner.next();
                    continue;
                }
                
                modo = scanner.nextInt();
                scanner.nextLine();

                if (modo == 0) {
                    System.out.println("Finalizando a aplicação Cliente. Até logo!");
                    break;
                }

                if (modo != 1 && modo != 2) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
                
                String prompt = (modo == 1) ? "ENCRIPTADA" : "DECRIPTADA";
                
                System.out.printf("DIGITE A CHAVE NUMÉRICA E A STRING PARA SER %s:\n", prompt);
                System.out.print(">> ");

                String linhaCompleta = scanner.nextLine();
                
                String[] partes = linhaCompleta.split(" ", 2);
                
                if (partes.length < 2) {
                    System.out.println("ERRO: Formato de entrada inválido. Use: CHAVE_NUMÉRICA TEXTO");
                    continue;
                }
                
                int chave = Integer.parseInt(partes[0].trim());
                String texto = partes[1].trim();
                
                System.out.println("Enviando requisição para o Servidor...");
                
                String resultado = servico.processaCriptografia(modo, chave, texto);
                
                System.out.println("\n--- RESULTADO DA OPERAÇÃO ---");
                System.out.println("  Operação: " + prompt);
                System.out.println("  Chave: " + chave);
                System.out.println("  Texto Processado: " + resultado);
                System.out.println("----------------------------------");

            } while (true);
            
        } catch (Exception e) {
            System.err.println("\nErro na aplicação Cliente: " + e.toString());
            System.err.println("VERIFIQUE: O Servidor e o RMI Registry estão rodando?");
        }
    }
}
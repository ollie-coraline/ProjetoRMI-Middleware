import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    
    public static void main(String[] args) {
        
        try {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Digite a mensagem para criptografar (inverter): ");
            String textoOriginal = scanner.nextLine();

            String url = "rmi://localhost:1099/CriptografiaService";
            
            ServicoCriptografia servico = (ServicoCriptografia) Naming.lookup(url);
            
            System.out.println("Cliente: Serviço encontrado! Enviando requisição...");
            
            String textoCriptografado = servico.inverteString(textoOriginal);
            
            System.out.println("\n----------------------------------");
            System.out.println("Mensagem Original: " + textoOriginal);
            System.out.println("Mensagem Criptografada: " + textoCriptografado);
            System.out.println("----------------------------------");

            scanner.close();
            
        } catch (Exception e) {
            System.err.println("Erro no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
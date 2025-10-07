import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacaoCriptografia extends UnicastRemoteObject implements ServicoCriptografia {

    private static int contadorDeChamadas = 0; 
    
    public ImplementacaoCriptografia() throws RemoteException {
        super();
    }

    // Lógica inverter string
    private String inverteString(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }
    
    // Lógica cifra de César
    private String cifraCesar(String texto, int chave, boolean encriptar) {
        StringBuilder resultado = new StringBuilder();
        chave = chave % 26;
        
        //Inverso pra decriptar
        if (!encriptar) {
            chave = -chave; 
        }

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (Character.isLetter(caractere)) {
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                int originalPosicao = caractere - base;
                int novaPosicao = (originalPosicao + chave) % 26;
                
                if (novaPosicao < 0) {
                    novaPosicao += 26;
                }
                
                char novoCaractere = (char) (base + novaPosicao);
                resultado.append(novoCaractere);
            } else {
                resultado.append(caractere);
            }
        }
        return resultado.toString();
    }

    @Override
    public synchronized String processaCriptografia(int modo, int chave, String texto) throws RemoteException {
        
        contadorDeChamadas++;
        
        String resultado = "";
        String operacao = (modo == 1) ? "ENCRIPTAR" : "DECRIPTAR";
        
        switch (modo) {
            case 1 ->                 {
                    String passo1 = cifraCesar(texto, chave, true);
                    resultado = inverteString(passo1);
                }
            case 2 ->                 {
                    String passo1 = inverteString(texto);
                    resultado = cifraCesar(passo1, chave, false);
                }
            default -> resultado = "Erro: Modo inválido.";
        }
        
        System.out.println("\nServidor (Thread " + Thread.currentThread().getId() + "): Operação: " + operacao);
        System.out.println("Servidor: Texto: '" + texto + "' | Chave: " + chave + " | Resultado: '" + resultado + "'");
        System.out.println("Servidor: Total de chamadas até agora: " + contadorDeChamadas);
        
        return resultado;
    }
}
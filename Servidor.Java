import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    
    public static void main(String[] args) {
        try {

            LocateRegistry.createRegistry(1099);
            
            ImplementacaoCriptografia objRemoto = new ImplementacaoCriptografia();
            
            Naming.rebind("rmi://localhost:1099/CriptografiaService", objRemoto);
            
            System.out.println("Servidor de Criptografia pronto e registrado.");
            
        } catch (Exception e) {
            System.err.println("Erro no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
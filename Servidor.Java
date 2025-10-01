import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {

    public static void main (String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry iniciado na porta 1099.");

            ImplementacaoCriptografia objRemoto = new ImplementacaoCriptografia();

            String url = "rmi://localhost:1099/CriptografiaService";
            Naming.rebind(url, objRemoto);

            System.out.println("Servidor de criptografia prointo e registrado na URL:"+ url);

        } catch (Exception e) {
            System.err.println("Erro no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
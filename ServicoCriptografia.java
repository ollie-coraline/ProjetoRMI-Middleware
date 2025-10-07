import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoCriptografia extends Remote {
    public String processaCriptografia(int modo, int chave, String texto) throws RemoteException;
}
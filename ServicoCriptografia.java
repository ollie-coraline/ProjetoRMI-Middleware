import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoCriptografia extends Remote {

    public String inverteString(String texto) throws RemoteException;
}
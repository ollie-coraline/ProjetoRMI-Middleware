import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoCriptografia extends Remote {
    
    /**
     * Recebe uma string (o texto a ser criptografado) e retorna 
     * a mesma string com a ordem dos caracteres invertida.
     * @param texto A string de entrada (mensagem original).
     * @return A string invertida (mensagem criptografada).
     * @throws RemoteException Obrigatório para métodos remotos.
     */
    public String inverteString(String texto) throws RemoteException;
}
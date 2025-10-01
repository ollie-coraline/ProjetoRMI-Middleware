// ImplementacaoCriptografia.java - (Versão Final com Sincronização)

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacaoCriptografia extends UnicastRemoteObject implements ServicoCriptografia {

    private static int contadorDeChamadas = 0; 
    
    public ImplementacaoCriptografia() throws RemoteException {
        super();
    }

    @Override
    public synchronized String inverteString(String texto) throws RemoteException {
        
        contadorDeChamadas++;

        StringBuilder sb = new StringBuilder(texto);
        String resultado = sb.reverse().toString();

        System.out.println("Servidor (Thread " + Thread.currentThread().getId() + "): Recebido: '" + texto + "'");
        System.out.println("Servidor: Total de chamadas até agora: " + contadorDeChamadas);
        
        return resultado;
    }
}
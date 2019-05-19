
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacion extends UnicastRemoteObject implements ServidorInterfaz {

    Implementacion() throws RemoteException {
        super();
    }

    @Override
    public float Algoritmo(String impresion) throws RemoteException {
        String[] tmp1 = impresion.split(" ");
        int sum = 0;
        for (int i = 0; i < tmp1.length; i++) {
            sum = sum + Integer.parseInt(tmp1[i]);
        }
        return sum / tmp1.length;
    }

}

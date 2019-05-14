
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacion extends UnicastRemoteObject implements ServidorInterfaz {

    Implementacion() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public float Algoritmo(String infoFicheroDat) throws RemoteException {
        String[] tmp1 = infoFicheroDat.split(" ");
        int valormedio = 0;
        for (int i = 0; i < tmp1.length; i++) {
            valormedio = valormedio + Integer.parseInt(tmp1[i]);
        }
        return (float)valormedio / tmp1.length;    
    }
}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorInterfaz extends Remote{
    
    public float Algoritmo(String impresion) throws RemoteException;   
   
}

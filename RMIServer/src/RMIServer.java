
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        try {
            Registry createRegistry = LocateRegistry.createRegistry(1330);
            ServidorInterfaz servidor = new Implementacion();
            Naming.bind("//localhost:1330/SERVIDOR", servidor);
            
            System.out.println("Soy el server");

        } catch (RemoteException ex) {
            System.out.println("Error: 2" + ex.getLocalizedMessage());
        }

    }

}

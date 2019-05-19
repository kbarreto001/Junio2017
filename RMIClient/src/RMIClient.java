
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {

        try {
            ServidorInterfaz objetoRemoto = (ServidorInterfaz) Naming.lookup("//localhost:1330/SERVIDOR");
            System.out.println("Soy el cliente");
            
            SupportC soporte = new SupportC();
            
            String impresion = soporte.LeerdifPos();
            System.out.println(impresion);
            System.out.println(objetoRemoto.Algoritmo(impresion));
            
        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }

    }

}

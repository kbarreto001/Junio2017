
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        String infoFicheroDat;
        try {
            ServidorInterfaz objetoRemoto = (ServidorInterfaz) Naming.lookup("//localhost:1330/SERVIDOR");
            System.out.println("Soy el cliente, obtenido objeto remoto");
            
            SupportC otro = new SupportC();
            infoFicheroDat = otro.VolcarFichero();
            System.out.println(objetoRemoto.Algoritmo(infoFicheroDat));

        } catch (RemoteException ex) {
            System.out.println("Error: 1" + ex.getLocalizedMessage());
        }
    }

}

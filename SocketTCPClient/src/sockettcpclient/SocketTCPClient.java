package sockettcpclient;

import ficherofinal.GuardarFicheroFinal;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import supportc.SupportC;

public class SocketTCPClient {
    protected static File ficheroF = new File("file.txt");
    public static void main(String[] args) throws IOException {
        String[] ficheroVolcado;
        try (
                Socket client = new Socket("localhost", 5000);
                DataInputStream disSocket = new DataInputStream(client.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(client.getOutputStream());) {
            
            SupportC otro =  new SupportC();
            GuardarFicheroFinal otro2 = new GuardarFicheroFinal();
            
            otro.EnviarNombreFich(ficheroF, dosSocket);
            ficheroVolcado = otro.VolcarFichero(ficheroF);
            otro.EnviarFichero(ficheroVolcado, dosSocket, disSocket);
            otro2.GuardarFinal(disSocket);
            otro2.LeerFicheroFinal();
            
        }
    }

}

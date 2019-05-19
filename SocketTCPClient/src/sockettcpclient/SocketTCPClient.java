package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketTCPClient {

    public static void main(String[] args) throws IOException {
        String[] ficheroVolcado;
        try (
                Socket client = new Socket("localhost", 5000);
                DataInputStream disSocket = new DataInputStream(client.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(client.getOutputStream());) {
            System.out.println("Soy el cliente");

            SupportC soporte = new SupportC();
            ficheroVolcado = soporte.VolcarFichero();
            soporte.EnviarFichero(dosSocket, ficheroVolcado);
            String difPos = soporte.RecibirdifPos(disSocket);
            soporte.GuardarFichero(difPos);
            System.out.println(soporte.LeerdifPos());
            
        }

    }

}

package sockettcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {

    public static void main(String[] args) throws IOException {
        int counter = 1, size = 1000;
        System.out.println("Soy el servidor");         
        try {
            ServerSocket server = new ServerSocket(5000, size);
            while (true) {
                Socket connection = server.accept();
                DataInputStream disSocket = new DataInputStream(connection.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(connection.getOutputStream());

                System.out.println("Recibida conexion No. " + counter + " from: " + connection.getInetAddress().getHostName());
                
                SupportS soporte = new SupportS();
                
                String[] ficheroVolcado = soporte.RecibirFichero(disSocket);
                soporte.GuardarFichero(ficheroVolcado);
                String difPos = soporte.Algoritmo(ficheroVolcado);
                soporte.EnviardifPos(difPos, dosSocket);
                

                connection.close();
                disSocket.close();
                dosSocket.close();
                counter++;
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }

    }

}

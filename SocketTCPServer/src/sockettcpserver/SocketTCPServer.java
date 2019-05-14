package sockettcpserver;

import algoritmo.AlgoritmoS;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import supports.SupportS;

public class SocketTCPServer {   

    public static void main(String[] args) {
        int counter = 1, size = 1000;
        System.out.println("Soy el servidor");
        String[] ficheroVolcado;
        String diferenciaPos;
        try {
            ServerSocket server = new ServerSocket(5000, size);
            while (true) {
                Socket connection = server.accept();
                DataInputStream disSocket = new DataInputStream(connection.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(connection.getOutputStream());
                System.out.println("Conexion No. " + counter + " Recibida de: " + connection.getInetAddress().getHostName());

                SupportS otro = new SupportS();
                AlgoritmoS otro2 = new AlgoritmoS();
                        
                ficheroVolcado=otro.RecibirFichero(disSocket, dosSocket);
                otro.GuardarFicheroVolcado(ficheroVolcado);
                diferenciaPos = otro2.Algoritmo(ficheroVolcado);
                otro.EnviarDiferenciaPositiva(dosSocket, diferenciaPos);
                

                connection.close();
                disSocket.close();
                dosSocket.close();
                counter++;
            }
        } catch (IOException ex) {
            System.out.println("Error 1: " + ex.getLocalizedMessage());

        }

    }

}

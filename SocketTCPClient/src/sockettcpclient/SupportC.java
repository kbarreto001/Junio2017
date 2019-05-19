package sockettcpclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SupportC {

    protected File file = new File("file.txt");
    protected File fileD = new File("file.dat");

    public String[] VolcarFichero() throws FileNotFoundException, IOException {
        int size = 0;
        String tmp1;
        String[] ficheroVolcado;
        try (
                BufferedReader brT = new BufferedReader(new FileReader(file));
                BufferedReader br = new BufferedReader(new FileReader(file));) {
            while ((tmp1 = brT.readLine()) != null) {
                size++;
            }
            ficheroVolcado = new String[size];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = br.readLine();
            }
        }
        return ficheroVolcado;
    }

    public void EnviarFichero(DataOutputStream dosSocket, String[] ficheroVolcado) throws IOException {
        try {
            dosSocket.writeUTF(file.getName());
            dosSocket.writeInt(ficheroVolcado.length);
            for (int i = 0; i < ficheroVolcado.length; i++) {
                dosSocket.writeUTF(ficheroVolcado[i]);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }

    public String RecibirdifPos(DataInputStream disSocket) {
        String difPos = null;
        try {
            difPos = disSocket.readUTF();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return difPos;
    }

    public void GuardarFichero(String difPos) throws IOException {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileD));) {
            dos.writeUTF(difPos);
        }
        System.out.println("Fichero Guardado");
    }
    
    public String LeerdifPos() throws FileNotFoundException, IOException{
        String impresion;
        try(
                DataInputStream dis = new DataInputStream(new FileInputStream(fileD));
                ){
            impresion = dis.readUTF();
        }
        return impresion;
    }

}

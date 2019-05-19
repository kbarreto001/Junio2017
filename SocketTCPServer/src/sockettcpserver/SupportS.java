package sockettcpserver;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SupportS {

    protected File file;

    public String[] RecibirFichero(DataInputStream disSocket) throws IOException {
        String[] ficheroVolcado = null;
        try {
            file = new File(disSocket.readUTF());
            System.out.println("Nombre de fichero: " + file.getName());
            ficheroVolcado = new String[disSocket.readInt()];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = disSocket.readUTF();
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return ficheroVolcado;
    }

    public void GuardarFichero(String[] ficheroVolcado) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
            for (int i = 0; i < ficheroVolcado.length; i++) {
                bw.write(ficheroVolcado[i] + "\n");
            }
        }
        System.out.println("Fichero Guardado");
    }

    public String Algoritmo(String[] ficheroVolcado) {
        String[] tmp1;
        int aux;
        String difPos = "";
        for (int i = 0; i < ficheroVolcado.length; i++) {
            tmp1 = ficheroVolcado[i].split(" ");
            for (int j = 0; j < tmp1.length; j++) {
                aux = Integer.parseInt(tmp1[j]);
                if (aux < 200) {
                    tmp1[j] = String.valueOf(200 - aux);
                } else {
                    tmp1[j] = String.valueOf(aux - 200);
                }
                difPos = difPos + tmp1[j] + " ";
            }
        }
        return difPos;
    }

    public void EnviardifPos(String disPos, DataOutputStream dosSocket) {
        try {
            dosSocket.writeUTF(disPos);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }
}

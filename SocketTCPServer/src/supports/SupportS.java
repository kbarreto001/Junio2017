package supports;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SupportS {

    protected String nombreFichero;

    public String[] RecibirFichero(DataInputStream disSocket, DataOutputStream dosSocket) throws IOException {
        nombreFichero = disSocket.readUTF();
        String[] ficheroVolcado;
        int tamaño = disSocket.readInt();
        ficheroVolcado = new String[tamaño];
        try {
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = disSocket.readUTF();
            }
        } catch (IOException ex) {
            System.out.println("Error 1: " + ex.getLocalizedMessage());
        }
        dosSocket.writeUTF(ficheroVolcado[ficheroVolcado.length - 1]);
        return ficheroVolcado;
    }

    public void GuardarFicheroVolcado(String[] ficheroVolcado) throws IOException {
        File ficheroN = new File(nombreFichero);
        try (
                BufferedWriter br = new BufferedWriter(new FileWriter(ficheroN));) {
            for (int i = 0; i < ficheroVolcado.length; i++) {
                br.write(ficheroVolcado[i] + "\n");
                System.out.println(ficheroVolcado[i]);
            }
        }
    }

    public void EnviarDiferenciaPositiva(DataOutputStream dosSocket, String diferenciaPos) {
        try {
            dosSocket.writeUTF(diferenciaPos);
        } catch (IOException ex) {
            System.out.println("Error 1: " + ex.getLocalizedMessage());
        }
    }

}

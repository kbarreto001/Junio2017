package supportc;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SupportC {

    public void EnviarNombreFich(File ficheroF, DataOutputStream dosSocket) {
        String nombreFichero = ficheroF.getName();
        try {
            dosSocket.writeUTF(nombreFichero);
        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
    }

    public String[] VolcarFichero(File ficheroF) throws FileNotFoundException, IOException {
        String tmp1;
        int tmp2 = 0;
        String[] ficheroVolcado;
        try (
                BufferedReader dis = new BufferedReader(new FileReader(ficheroF));
                BufferedReader disT = new BufferedReader(new FileReader(ficheroF));) {
            while ((tmp1 = disT.readLine()) != null) {
                tmp2++;
            }
            ficheroVolcado = new String[tmp2];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = dis.readLine();
            }
        }
        return ficheroVolcado;
    }

    public void EnviarFichero(String[] ficheroVolcado, DataOutputStream dosSocket, DataInputStream disSocket) {
        int tamaño = ficheroVolcado.length;
        String tmp;
        try {
            dosSocket.writeInt(tamaño);

            for (int i = 0; i < ficheroVolcado.length; i++) {
                dosSocket.writeUTF(ficheroVolcado[i]);
            }

            if ((tmp=disSocket.readUTF()).equals(ficheroVolcado[ficheroVolcado.length - 1])) {
                System.out.println("fichero enviado correctamente");
            } else {
                System.out.println("fichero enviado incorrectamente");
            }

        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
    }

}

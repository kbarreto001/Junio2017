
package ficherofinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GuardarFicheroFinal {
    protected File ficheroFinal = new File("file.dat");
    
    public void GuardarFinal(DataInputStream disSocket) throws FileNotFoundException, IOException{
        String diferenciaPos=null;        
        try{
            diferenciaPos = disSocket.readUTF();            
        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroFinal));               
                ){
            dos.writeUTF(diferenciaPos);
        }
    }
    
    public void LeerFicheroFinal () throws FileNotFoundException, IOException{
        try(
                DataInputStream dis = new DataInputStream(new FileInputStream(ficheroFinal));
                ){
            System.out.println("Leyendo del fichero:  "+dis.readUTF());
        }
    }
            
    
}

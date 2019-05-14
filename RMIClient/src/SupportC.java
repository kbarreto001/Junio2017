
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SupportC {

    protected File ficheroDat = new File("file.dat");

    public String VolcarFichero() throws FileNotFoundException, IOException {
        String infoFicheroDat;
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(ficheroDat));) {
            infoFicheroDat = dis.readUTF();
            System.out.println(infoFicheroDat);
        }
        return infoFicheroDat;
    }   

}

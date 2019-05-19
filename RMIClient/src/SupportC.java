
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SupportC {

    protected File fileD = new File("file.dat");

    public String LeerdifPos() throws FileNotFoundException, IOException {
        String impresion;
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(fileD));) {
            impresion = dis.readUTF();
        }
        return impresion;
    }

}

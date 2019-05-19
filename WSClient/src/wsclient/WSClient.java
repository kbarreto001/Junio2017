package wsclient;

import java.util.HashSet;
import java.util.Set;

public class WSClient {

    public static void main(String[] args) {
        String textoTeclado = "carlos maria juan carlos";

        String[] tmp1 = textoTeclado.split(" ");

        Set<String> sinRep = new HashSet<>();
        
        for (int i = 0; i < tmp1.length; i++) {
            sinRep.add(tmp1[i]);
        }
        
        String tmp2 = sinRep.toString();
        String [] tmp3 = new String[sinRep.size()];
        tmp3 = tmp2.split(" ");
        for (int i = 0; i < tmp3.length; i++) {            
            tmp3[i] = tmp3[i].replace("[", "").replace(",", "").replace("]", "");
            System.out.println(tmp3[i]);
        }      
        

    }

}

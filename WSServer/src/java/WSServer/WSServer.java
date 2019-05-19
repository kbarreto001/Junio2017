package WSServer;

import java.util.HashSet;
import java.util.Set;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "WSServer")
@Stateless()
public class WSServer {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "PalabraRep")
    public String PalabraRep(@WebParam(name = "textoTeclado") String textoTeclado) {
        String[] tmp1 = textoTeclado.split(" ");
        Object[] tmp2;

        Set<String> sinRep = new HashSet<>();
        for (int i = 0; i < tmp1.length; i++) {
            sinRep.add(tmp1[i]);
        }

        tmp2 = sinRep.toArray();

        for (int i = 0; i < tmp2.length; i++) {
            System.out.println(tmp2);
        }

            return "Ready";
        }
    }

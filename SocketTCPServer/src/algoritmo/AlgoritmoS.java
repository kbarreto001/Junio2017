package algoritmo;

public class AlgoritmoS {

    public String Algoritmo(String[] ficheroVolcado) {
        String[] tmp1;
        String diferenciaPos="";
        int tmp3;
        for (int i = 0; i < ficheroVolcado.length; i++) {
            tmp1 = ficheroVolcado[i].split(" ");
            for (int j = 0; j < tmp1.length; j++) {
                if ((tmp3=Integer.parseInt(tmp1[j])) < 200) {
                    tmp1[j] = String.valueOf(200-tmp3);
                } else {
                    tmp1[j] = String.valueOf(tmp3 - 200);
                }
                diferenciaPos = diferenciaPos + tmp1[j] + " ";
            }
        }
        System.out.println(diferenciaPos);
        return diferenciaPos;
    }

}

import java.io.*;

public class Histograma {
    public static void main(String[] args) {

        try {
            String ruta = "src\\divina_comedia_sp.txt";
            String newRuta = "src\\archivo.txt";

            BufferedReader br = new BufferedReader(new FileReader(ruta));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newRuta));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null){
                sb.append(line).append(" ");
            }

            String palabras[] = sb.toString().split("\\s+");
            int his[] = new int[11];

            for (int i = 0; i < palabras.length; i++) {
                String palabra = palabras[i];

                if (palabra.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ$]{2,10}")){
                    int longitud = palabra.length();
                    his[longitud]++;
                }

            }

            for (int i = 2; i <= 10; i++) {
                bw.write("Hay "+ his[i]+ " palabras de " + i+ " caracteres \n");
            }

            bw.flush();
            bw.close();

        }catch (IOException e){
            System.out.println("Hubo un error al abrir el archivo "+ e.getMessage());
        }
    }

}
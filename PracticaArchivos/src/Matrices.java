import java.io.*;

public class Matrices{
    public static void main(String[] args) {

        try{
            DataInputStream a= new DataInputStream(new FileInputStream("src/a.mat"));
            int nFilasA= a.readByte();
            int nColumnasA = a.readByte();
            double matrizA[][]= new double[nFilasA][nColumnasA];

            for (int i = 0; i < nFilasA; i++) {
                for (int j = 0; j < nColumnasA; j++) {
                    matrizA[i][j]= a.readDouble();
                }
            }
            a.close();

            DataInputStream b = new DataInputStream(new FileInputStream("src/b.mat"));
            int nFilasB = b.readByte();
            int nColumnasB = b.readByte();
            double matrizB[][]= new double[nFilasA][nColumnasB];

            for (int i = 0; i < nFilasB; i++) {
                for (int j = 0; j < nColumnasB; j++) {
                    matrizB[i][j]= b.readDouble();
                }
            }
            b.close();

            if (nColumnasA==nFilasB){
                double matrizC[][]= new double[nFilasA][nColumnasB];
                for (int i = 0; i < nFilasA; i++) {
                    for (int j = 0; j <nColumnasB ; j++) {
                        matrizC[i][j] = 0;
                        for (int k = 0; k < nColumnasA; k++) {
                            matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                        }
                    }
                }

                DataOutputStream c= new DataOutputStream(new FileOutputStream("src/c.mat"));
                c.writeByte(nFilasA);
                c.writeByte(nColumnasB);
                for (int i = 0; i < nFilasA; i++) {
                    for (int j = 0; j < nColumnasB; j++) {
                        c.writeDouble(matrizC[i][j]);
                    }
                }
                for (int i = 0; i < nFilasA; i++) {
                    for (int j = 0; j < nColumnasB; j++) {
                        System.out.print(matrizC[i][j]+"\t");
                        //System.out.println();
                    }
                    System.out.println();
                }
                c.close();
            }//end if
            else {
                System.out.println("No se puede multiplicar");
            }

        }catch (IOException e){
            System.out.println("Error al abrir el archivo "+e.getMessage());
        }
    }

}

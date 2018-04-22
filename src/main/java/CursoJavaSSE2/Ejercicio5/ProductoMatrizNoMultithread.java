package CursoJavaSSE2.Ejercicio5;

public class ProductoMatrizNoMultithread extends Thread{

    private int [][] matrizA;
    private int [][] matrizB;
    private int [][] matrizC;

    public ProductoMatrizNoMultithread(int [][] matrizA, int [][] matrizB){
        this.matrizA=matrizA;
        this.matrizB=matrizB;
    }

    public void run() {

        matrizC = new int[matrizA.length][matrizB[0].length];

        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[0].length; j++)
                for (int k = 0; k < matrizA[0].length; k++) matrizC[i][j] += matrizA[i][k] * matrizB[k][j];


        }

        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[0].length; j++) {
                System.out.print("| "+matrizC[i][j]+" |");
            }
            System.out.print("\n");
        }

    }

}

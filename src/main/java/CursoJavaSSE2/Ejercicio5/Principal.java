package CursoJavaSSE2.Ejercicio5;

public class Principal {
    public static void main(String[] Args){

        int [][] MatrizA = new int[3][2];
        int [][] MatrizB = new int[2][3];

        llenadoMatrizes(MatrizA);
        llenadoMatrizes(MatrizB);

        ProductoMatrizNoMultithread A = new ProductoMatrizNoMultithread(MatrizA,MatrizB);

        A.start();
    }

    public static void llenadoMatrizes(int [][] M){
        int num = 1;
        for (int i = 0; i < M.length ; i++) {
            for (int j = 0; j < M[0].length; j++) {
                M[i][j]=num;
                num+=1;
            }
        }

    }
}

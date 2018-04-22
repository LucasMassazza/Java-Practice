package FuncionesUtiles;

public class LlenadoMatriz {

    public int [][]llenadoMatrizes(int [][] M){
        int [][] matrixC = M;
        int num = 1;
        for (int i = 0; i < matrixC.length ; i++) {
            for (int j = 0; j < matrixC[0].length; j++) {
                matrixC[i][j]=num;
                num+=1;
            }
        }
        return matrixC;
    }
}

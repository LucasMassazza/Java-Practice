package EvaluacionPrimerPreviaBarbutto;

import java.util.concurrent.Semaphore;

public class Matrix {

    private int [][] matriz;
    private Semaphore [] arraySemaphore;
    private int x;
    private int y;


    public Matrix(int x,int y){
        this.matriz=new int [x][y];
        this.arraySemaphore = new Semaphore[matriz[0].length];
        for (int i = 0; i < arraySemaphore.length; i++) {
            arraySemaphore[i]=new Semaphore(1);
        }
        this.x=x;
        this.y=y;
    }

    public int getColumns(){
        return y;
    }

    public int getRows(){
        return x;
    }

    public int get(int row,int col){
        return matriz[row][col];
    }

    public void set(int row,int column,int value){
        matriz[row][column]=value;
    }


}

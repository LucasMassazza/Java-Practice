package Guia3Barbutto.Ejercicio12.Bis;

import Guia3Barbutto.Ejercicio12.Matrix;

public class Ejercicio14 extends Matrix {
    public Ejercicio14(int rows, int columns) {
        super(rows, columns);
    }

    public Ejercicio14(double[][] elements) {
        super(elements);
    }

    public Ejercicio14(Matrix matrix) {
        super(matrix);
    }

    public boolean esDiagonal(Matrix matriz){

        for (int i = 0; i < matriz.rows(); i++) {
            for (int j = 0; j < matriz.columns(); j++) {
                if(i==j){
                    if(matriz.get(i,j)==0){
                        return false;
                    }
                }else{
                    if (matriz.get(i,j)!=0){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

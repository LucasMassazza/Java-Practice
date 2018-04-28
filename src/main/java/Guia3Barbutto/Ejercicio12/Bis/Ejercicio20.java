package Guia3Barbutto.Ejercicio12.Bis;

import Guia3Barbutto.Ejercicio12.Matrix;

public class Ejercicio20 extends Matrix {

    public Ejercicio20(int rows, int columns) {
        super(rows, columns);
    }

    public Ejercicio20(double[][] elements) {
        super(elements);
    }

    public Ejercicio20(Matrix matrix) {
        super(matrix);
    }

    public boolean esSimetrica(Matrix matrix){

        Ejercicio19 ejercicio19 = new Ejercicio19(matrix);

        Matrix maatrixT = new Matrix(matrix.rows(),matrix.columns());

        maatrixT =  ejercicio19.transponerMatriz(matrix);

        for (int i = 0; i < matrix.rows(); i++) {
            if(matrix.get(i,i)==maatrixT.get(i,i)){
                return false;
            }
        }

        return true;
    }
}

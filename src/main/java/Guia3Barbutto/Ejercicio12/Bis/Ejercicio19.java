package Guia3Barbutto.Ejercicio12.Bis;

import Guia3Barbutto.Ejercicio12.Matrix;

public class Ejercicio19 extends Matrix {
    public Ejercicio19(int rows, int columns) {
        super(rows, columns);
    }

    public Ejercicio19(double[][] elements) {
        super(elements);
    }

    public Ejercicio19(Matrix matrix) {
        super(matrix);
    }

    public Matrix transponerMatriz(Matrix matrix){

        Matrix matrix1 = new Matrix(matrix.rows(),matrix.columns());

        for (int i = 0; i < matrix1.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                matrix1.set(j,i,matrix.get(i,j));
            }
        }

        return matrix1;
    }
}

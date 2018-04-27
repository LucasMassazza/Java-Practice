package Guia3Barbutto.Ejercicio12.Bis;

import Guia3Barbutto.Ejercicio12.Matrix;

public class Ejercicio17 extends Matrix {
    public Ejercicio17(int rows, int columns) {
        super(rows, columns);
    }

    public Ejercicio17(double[][] elements) {
        super(elements);
    }

    public Ejercicio17(Matrix matrix) {
        super(matrix);
    }

    public Matrix restaMatrices(Matrix matrix){
        Matrix newMatrix = new Matrix(matrix.rows(),matrix.columns());

        for (int i = 0; i < newMatrix.rows(); i++) {
            for (int j = 0; j < newMatrix.columns(); j++) {
                newMatrix.set(i,j,(this.get(i,j)-matrix.get(i,j)));
            }
        }

        return newMatrix;
    }
}

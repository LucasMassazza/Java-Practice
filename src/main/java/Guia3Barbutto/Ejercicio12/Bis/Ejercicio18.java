package Guia3Barbutto.Ejercicio12.Bis;

import Guia3Barbutto.Ejercicio12.Matrix;

public class Ejercicio18 extends Matrix {
    public Ejercicio18(int rows, int columns) {
        super(rows, columns);
    }

    public Ejercicio18(double[][] elements) {
        super(elements);
    }

    public Ejercicio18(Matrix matrix) {
        super(matrix);
    }
    public Matrix productoMatrices(Matrix matrix){
        Matrix newMatrix = new Matrix(matrix.rows(),matrix.columns());

        for (int i = 0; i < newMatrix.rows(); i++) {
            for (int j = 0; j < newMatrix.columns(); j++) {
                newMatrix.set(i,j,(this.get(i,j)*matrix.get(i,j)));
            }
        }

        return newMatrix;
    }

}

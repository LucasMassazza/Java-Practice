package Guia3Barbutto.Ejercicio12.Bis;

import Guia3Barbutto.Ejercicio12.Matrix;

public class Ejercicio15 extends Matrix {
    public Ejercicio15(int rows, int columns) {
        super(rows, columns);
    }

    public Ejercicio15(double[][] elements) {
        super(elements);
    }

    public Ejercicio15(Matrix matrix) {
        super(matrix);
    }

    public void multiplicarMatriz(Matrix matrix,int multiplicador){

        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                matrix.set(i,j,matrix.get(i,j)*multiplicador);
            }
        }
    }
}

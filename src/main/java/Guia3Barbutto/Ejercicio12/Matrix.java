package Guia3Barbutto.Ejercicio12;

public class Matrix {

        private double[][] matriz;

        public Matrix(int rows,int columns){
            matriz = new double[rows][columns];
        }

        public Matrix(double[][] elements){
            matriz=elements;
        }

        public Matrix(Matrix matrix){

            matriz = new double[matrix.rows()][matrix.columns()];

            for (int i = 0; i < matrix.rows(); i++) {
                for (int j = 0; j < matrix.columns(); j++) {
                    this.set(i,j,matrix.get(i,j));
                }
            }
        }

        public int rows(){
            return matriz.length;
        }

        public int columns(){
            return matriz[0].length;
        }

        public  double get (int row,int column){
            return matriz[row][column];
        }

        public void set (int row,int column, double value){
            matriz[row][column]=value;
        }
}

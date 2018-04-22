package Prueba;

import EvaluacionPrimerPreviaBarbutto.Matrix;

import java.util.Random;

public class Decodificacion {

    public static void main(String[]Args){

        Codificacion codificado = new Codificacion();
        Decodificacion decodificacion = new Decodificacion();
        Matrix matrix = new Matrix(4,4);
        Random random = new Random();

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.set(i,j,random.nextInt(10)+1);
            }
        }

        int [] arrayCodificado = codificado.Codificacion(matrix);

        for (int i = 0; i <arrayCodificado.length ; i++) {
            System.out.println(arrayCodificado[i]);
        }

    }


    public Matrix Decodificacion(int[] codificado,int rows,int cols){

            Matrix matrizDecodificada = new Matrix(rows,cols);

        for (int i = 0; i < matrizDecodificada.getRows(); i++) {
            for (int j = 0; j < matrizDecodificada.getColumns(); j++) {



            }
        }


        return matrizDecodificada;
    }

}

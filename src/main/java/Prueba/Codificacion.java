package Prueba;

import EvaluacionPrimerPreviaBarbutto.Matrix;

import java.util.ArrayList;
import java.util.Random;

public class Codificacion {
    public static void main(String[] Args){

        Codificacion a = new Codificacion();

        Matrix matrix = new Matrix(4,4);
        Random random = new Random();

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.set(i,j,random.nextInt(10)+1);
            }
        }

        int [] array = a.Codificacion(matrix);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }



    }


    public int[] Codificacion(Matrix matrix){
        ArrayList<Integer> listaCodificados = new ArrayList(0);
        ArrayList<Integer> listaYaCodificados = new ArrayList(0);

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if(!listaYaCodificados.contains(matrix.get(i,j))){
                    if(ContadorDeVecesNumero(matrix,matrix.get(i,j))>1){
                        listaCodificados.add(matrix.get(i,j));
                        listaCodificados.add(192+ContadorDeVecesNumero(matrix,matrix.get(i,j)));
                    }else {
                        if(matrix.get(i,j)>=192){
                            listaCodificados.add(matrix.get(i,j));
                            listaCodificados.add(192);
                        }else{
                            listaCodificados.add(matrix.get(i,j));
                        }
                    }
                }
                listaYaCodificados.add(matrix.get(i,j));
            }
        }




        return PasajeArrayListAArray(listaCodificados);
    }

    public int ContadorDeVecesNumero(Matrix matrix, int num){

        int Repeticiones=0;

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if(matrix.get(i,j)==num){
                    Repeticiones++;
                }
            }

        }

        return Repeticiones;
    }

    public int[] PasajeArrayListAArray(ArrayList<Integer> lista){
        int [] arrayCodificado = new int[lista.size()];

        for (int i = 0; i < arrayCodificado.length; i++) {
            arrayCodificado[i]=lista.get(i);
        }

        return arrayCodificado;
    }

}

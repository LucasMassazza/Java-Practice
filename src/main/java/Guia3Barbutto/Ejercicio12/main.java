package Guia3Barbutto.Ejercicio12;

import Guia3Barbutto.Ejercicio12.Bis.Ejercicio14;
import Guia3Barbutto.Ejercicio12.Bis.Ejercicio15;

public class main {

    public static void main(String[]Args){

        Ejercicio14 ejercicio14 = new Ejercicio14(4,4);
        Ejercicio15 ejercicio15 = new Ejercicio15(5,4);

        for (int i = 0; i < ejercicio14.rows(); i++) {
            ejercicio14.set(i,i,1);
        }
        int contador=0;
        for (int i = 0; i < ejercicio15.rows(); i++) {
            for (int j = 0; j < ejercicio15.columns(); j++) {
                ejercicio15.set(i,j,contador);
                contador++;
            }
        }

        ejercicio15.multiplicarMatriz(ejercicio15,5);

        mostrar(ejercicio15);

        System.out.println("\n\n");

        if(ejercicio14.esDiagonal(ejercicio14)){
            System.out.println("OK");
            for (int i = 0; i < ejercicio14.rows(); i++) {
                for (int j = 0; j < ejercicio14.columns(); j++) {
                    System.out.print("|"+ejercicio14.get(i,j)+"|");
                }
                System.out.println();
            }


        }else{
            System.out.println("NOP");
        }



    }

    public static void mostrar(Matrix matrix){
        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                System.out.print("|"+matrix.get(i,j)+"|");
            }
            System.out.println("");
        }
    }
}

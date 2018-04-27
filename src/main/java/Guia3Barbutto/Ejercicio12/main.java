package Guia3Barbutto.Ejercicio12;

import Guia3Barbutto.Ejercicio12.Bis.Ejercicio14;

public class main {

    public static void main(String[]Args){

        Ejercicio14 ejercicio14 = new Ejercicio14(4,4);

        for (int i = 0; i < ejercicio14.rows(); i++) {
            ejercicio14.set(i,i,1);
        }

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
}

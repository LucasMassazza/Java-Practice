package FuncionesUtiles;

import java.util.Random;

public class BubbleSort {


    public static void main(String[] Args){

        Random random  = new Random();

        int [] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i]=random.nextInt(10)-1;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print("| "+array[i]+" |");
        }

        array=bubbleSort(array);
        System.out.print("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print("| "+array[i]+" |");
        }


    }

    public static int[] bubbleSort (int[] array){

        int aux;

        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j]<array[j+1]){
                    aux = array[j+1];
                    array[j+1]=array[j];
                    array[j]=aux;
                }
            }
        }


        return array;
    }

}

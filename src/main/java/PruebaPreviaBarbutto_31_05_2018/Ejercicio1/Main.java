package PruebaPreviaBarbutto_31_05_2018.Ejercicio1;

public class Main {

    public static void main(String[] Args){

        int [] array = {2,4,2,2,2,2,4,4,4};

        Compactar compactar = new Compactar();

        for (int i = 0; i < array.length; i++) {
            System.out.print("| "+array[i]+" |");
        }

        array=compactar.colapsar(array);

        System.out.println("\n\n\n");

        for (int i = 0; i < array.length; i++) {
            if(array[i]!=-1){
                System.out.print("| "+array[i]+" |");
            }

        }


    }


}

package Prueba;

import EvaluacionTercerTermino11_12.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cola {



    public static void main(String[]Args){
        ArrayList<Integer> lista = new ArrayList(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(10)+1);
        }

        System.out.println(lista.size());



        System.out.println(lista.size());

        lista.add(10);

        System.out.println(lista.size());
    }

}

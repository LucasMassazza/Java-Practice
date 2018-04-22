package EvaluacionTercerTermino11_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Queue {
    private Random random = new Random();
    private int [] cola;
    private int indice;

    public Queue(int tamano){
        cola = new int[tamano];
    }

    public Queue(){
        cola = new int[4];
    }

    public void queue(int numero){
        if(indice==0){
            cola[indice]=numero;
            indice++;
        }else{
            cola[indice]=numero;
            if(indice<(cola.length-1)){
                indice++;
            }
            if(indice==(cola.length-1)){
                cola[indice]=random.nextInt(100)+1;
            }
        }
    }

    public int deQueue(){
        int num = cola[indice];
        indice--;
        return num;
    }

    public boolean isEmpty(){
        if(indice==0){
            return true;
        }

        return false;
    }

    public boolean isFull(){
        if(indice==(cola.length-1)){
            return true;

        }

        return false;
    }



}

package EvaluacionTercerTermino11_12;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class Llenador extends Thread{

    private Queue cola;
    private Semaphore semaforoA;

    public Llenador(Queue cola,Semaphore semaforoA){
        this.cola=cola;

        this.semaforoA=semaforoA;
    }
    @Override
    public void run(){
        Random random = new Random();
        while(true){

            if(!cola.isFull()){
                try {
                    semaforoA.acquire();
                    while(!cola.isFull()){
                        cola.queue(random.nextInt(100)+1);
                    }
                    semaforoA.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }
}

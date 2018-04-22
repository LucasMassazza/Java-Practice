package CursoJavaSSE2.Ejercicio2;

import java.util.concurrent.Semaphore;

public class Threads extends java.lang.Thread{

    private int Entero;
    Semaphore Semaforo = new Semaphore(1);

    public Threads(int Entero){
        this.Entero=Entero;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            try {
                Semaforo.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Entero+=1;
            Semaforo.release();
            System.out.println(Entero);
        }
    }

    public int DevolverTotal(){
        return this.Entero;
    }

}

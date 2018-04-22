package CursoJavaSSE2.Ejercicio1;

public class Threads extends Thread {

    private int contador;

    public Threads(int contador) {
        this.contador=contador;
    }

    public void run() {

        if(contador<50) {
            Threads B = new Threads(contador+1);

            B.start();
            try {
                B.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Hilo A :"+contador);
        }else {
            System.out.println("Hilo: "+contador);
        }


    }
}

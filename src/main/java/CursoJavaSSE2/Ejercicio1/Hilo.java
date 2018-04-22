package CursoJavaSSE2.Ejercicio1;

public class Hilo extends Thread {

    private int numero;

    public Hilo(int Integer){
        this.numero=Integer;
    }

    @Override
    public void run(){
        if(numero<50){

            Hilo A = new Hilo(numero+1);


            A.start();
            try {
                A.join();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo B:"+numero);

        }else{
            System.out.println("Hilo B:"+numero);
        }
    }


}

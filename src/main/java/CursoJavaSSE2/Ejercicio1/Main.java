package CursoJavaSSE2.Ejercicio1;

public class Main {

    public static void main(String[]Args){

        Threads A = new Threads (0);
        Hilo B = new Hilo(0);

        B.start();
        A.start();


    }
}

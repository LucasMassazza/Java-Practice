package CursoJavaSSE2.Ejercicio2;

import static java.lang.Thread.sleep;

public class main {

    public static void main(String[]Args) throws InterruptedException {

        Threads Integers = new Threads(0);

        Thread A = new Thread(Integers);
        Thread B = new Thread(Integers);
        Thread C = new Thread(Integers);
        Thread D = new Thread(Integers);

        A.start();
        B.start();
        C.start();
        D.start();

        sleep(5000);
        System.out.println("Total es: "+Integers.DevolverTotal());
    }


}

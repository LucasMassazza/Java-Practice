package EvaluacionTercerTermino11_12;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Servidor {

    public static void main(String[]Args) throws Exception{

        Socket socket;
        ServerSocket ss = new ServerSocket(65432);
        Queue cola = new Queue(10);
        Semaphore semaforoA = new Semaphore(1);
        Semaphore semaforoB = new Semaphore(1);
        Handler handler;

        while(true){
            socket = ss.accept();
            System.out.println("CONECTADO...");
            handler = new Handler(socket,semaforoA,semaforoB,cola);
            handler.start();
        }




    }

}

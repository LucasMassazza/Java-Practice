package PruebaPreviaBarbutto_31_05_2018.Ejercicio4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Servidor {

    public static void main(String[] Args){

        Socket socket;
        ServerSocket ss;

        try{
            ss = new ServerSocket(1234);

            Cola arrayCompartido = new Cola(10);
            Handler handler;
            Semaphore semaphore = new Semaphore(1);

            while (true){

                socket = ss.accept();

                handler = new Handler(arrayCompartido,semaphore,socket);

                handler.start();

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutoo_11_12;

import EvaluacionTercerTermino11_12.Queue;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Servidor {

    public static void main(String[]Args) throws Exception{


        ServerSocket ss = new ServerSocket(54321);
        Socket socket;

        Queue cola = new Queue();
        Semaphore semaforo = new Semaphore(1);
        Handler handler;


        while (true){

            socket = ss.accept();




        }




    }

}

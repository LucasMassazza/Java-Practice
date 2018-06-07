package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutto_15_03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Servidor {

    public static void main(String[]Args){

        Socket socket=null;
        ServerSocket ss;

        try {
            ss = new ServerSocket(12345);
            int[][] matrizEnteros = new int[640][480];
            Semaphore[] arraySemaforos = new Semaphore[matrizEnteros.length];

            Handler handler;

            for (int i = 0; i < arraySemaforos.length; i++) {
                arraySemaforos[i]=new Semaphore(1);
            }

            while (true){

                socket = ss.accept();

                handler = new Handler(socket,arraySemaforos,matrizEnteros);

                handler.start();

            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(socket!=null){
                    socket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

}

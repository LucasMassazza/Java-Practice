package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutoo_11_12;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Handler extends Thread {

    private Socket socket;
    private Semaphore semaphore;
    private Queue cola;
    private int[]arrayDecodificado;

    public Handler (Socket socket,Semaphore semaphore,Queue queue){

        this.socket=socket;
        this.semaphore=semaphore;
        this.cola=queue;

    }

    public void run(){
        PrintWriter out = null;
        Scanner in = null;

        try{

            int opcion = in.nextInt();



            if(opcion==1){

                int cantidad = in.nextInt();
                arrayDecodificado = new int[cantidad];
                for (int i = 0; i <= cantidad; i++) {
                    if(!cola.isEmpty()){
                        semaphore.acquire();
                        if(!cola.isEmpty()){
                            arrayDecodificado[i] = cola.remove();
                        }
                    }
                }
            }else{

            }

        }catch (Exception e){

        }finally {
            if (out!=null){
                out.close();
            }

            if (in!=null){
                in.close();
            }
        }
    }

}

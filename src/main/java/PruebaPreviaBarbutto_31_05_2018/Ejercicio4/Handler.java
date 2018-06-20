package PruebaPreviaBarbutto_31_05_2018.Ejercicio4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Handler extends Thread {


    private Cola arrayCompartido;
    private Semaphore semaphore;
    private Socket socket;

    public Handler(Cola arrayCompartido,Semaphore semaphore,Socket socket){
        this.arrayCompartido=arrayCompartido;
        this.semaphore=semaphore;
        this.socket=socket;
    }

    @Override
    public void run(){

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner in = new Scanner(socket.getInputStream());

            if(arrayCompartido.lleno()){
                semaphore.acquire();
                if(arrayCompartido.lleno()){
                    out.println("POST");
                    out.println(arrayCompartido.tamanoArray());
                    for (int i = 0; i < arrayCompartido.tamanoArray(); i++) {
                        out.println(arrayCompartido.getArray(i));
                    }
                }
                arrayCompartido.volverACeroIndice();
                semaphore.release();
            }else{
                out.println("GET");
                int numero = in.nextInt();

                if(!arrayCompartido.lleno()){
                    semaphore.acquire();
                    if (!arrayCompartido.lleno()){

                        arrayCompartido.ingresarArray(numero);
                        arrayCompartido.sumarIndice();

                    }
                    semaphore.release();
                }
            }


        }catch (Exception e){
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

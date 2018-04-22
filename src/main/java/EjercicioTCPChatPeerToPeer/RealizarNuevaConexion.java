package EjercicioTCPChatPeerToPeer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RealizarNuevaConexion extends Thread{

    private ServerSocket ss;
    private Socket socket;

    public RealizarNuevaConexion(ServerSocket ss){
        this.ss=ss;
    }

    public RealizarNuevaConexion(ServerSocket ss,Socket socket){
        this.ss=ss;
        this.socket=socket;
    }


    public void run(){

        Scanner stdin = new Scanner(System.in);
        int Puerto;
        String IP;
        ReceptorMensajes receptorMensajes;
        EmisorMensajes emisorMensajes;


        if(socket==null){
            System.out.println("Ingrese la IP del otro Cliente: ");
            IP = stdin.nextLine();
            System.out.print("Ingrese el Puerto del otro cliente: ");
            Puerto = stdin.nextInt();
            try {
                socket = new Socket(IP,Puerto);
            } catch (IOException e) {
                e.printStackTrace();
            }

            receptorMensajes = new ReceptorMensajes(socket,ss);
            emisorMensajes = new EmisorMensajes(socket,ss);

        }else{

            receptorMensajes = new ReceptorMensajes(socket,ss);
            emisorMensajes = new EmisorMensajes(socket,ss);

            receptorMensajes.start();
            emisorMensajes.start();

        }







    }

}

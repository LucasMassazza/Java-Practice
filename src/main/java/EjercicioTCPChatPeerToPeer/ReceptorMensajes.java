package EjercicioTCPChatPeerToPeer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ReceptorMensajes extends Thread{

    private Socket socket;
    private ServerSocket ss;

    public ReceptorMensajes(Socket socket, ServerSocket ss){
        this.socket=socket;
        this.ss=ss;
    }

    @Override
    public void run(){

        try {
            Scanner in = new Scanner(socket.getInputStream());

            String mensaje = new String();

            while(!mensaje.equals("/Desconectar")){

                mensaje=in.nextLine();

                System.out.println("==> "+mensaje);

            }

            System.out.println("Usuario Desconectado...");
        }catch (Exception e){

        }



    }
}

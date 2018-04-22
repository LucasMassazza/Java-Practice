package EjercicioTCPChatPeerToPeer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EmisorMensajes extends Thread{

    private Socket socket;
    private ServerSocket ss;

    public EmisorMensajes(Socket socket,ServerSocket ss){
        this.socket=socket;
        this.ss=ss;
    }

    public void run(){
        try {

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            String mensajeParaEnviar="";
            Scanner stdin = new Scanner(System.in);
            RealizarNuevaConexion realizarNuevaConexion = new RealizarNuevaConexion(ss);

            while(!mensajeParaEnviar.equals("/Desconectar")){
                mensajeParaEnviar = stdin.nextLine();

                if(mensajeParaEnviar.equals("/NuevaConexion")){

                }else{
                    out.println("<=="+mensajeParaEnviar);
                }
            }
        }catch (Exception e){

        }
    }

}

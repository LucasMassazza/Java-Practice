package EjercicioTCPChatPeerToPeer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class main {

    public static void main(String[]Args)throws Exception{


        Socket socket;
        int Puerto = 0;
        Scanner stdin = new Scanner(System.in);

        System.out.println("Ingrese el puerto a utilizar: ");

        Puerto = stdin.nextInt();

        ServerSocket ss = new ServerSocket(Puerto);

        RealizarNuevaConexion nuevaConexion = new RealizarNuevaConexion(ss);

        nuevaConexion.start();


        while(true){

            socket = ss.accept();

            nuevaConexion = new RealizarNuevaConexion(ss,socket);

            nuevaConexion.start();

        }


    }

}

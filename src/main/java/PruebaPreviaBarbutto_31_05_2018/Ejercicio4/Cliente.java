package PruebaPreviaBarbutto_31_05_2018.Ejercicio4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[]Args){

        Socket socket;

        try {
            socket = new Socket("localhost",1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner stdin = new Scanner(System.in);

            String opcion = in.nextLine();

            if(opcion.equals("POST")){
                int tamanoArray = in.nextInt();
                int[] array = new int[tamanoArray];

                for (int i = 0; i < array.length; i++) {
                    array[i]=in.nextInt();
                    System.out.print("| "+array[i]+" |");
                }
            }else if(opcion.equals("GET")){
                System.out.println("Which number do you want to put: ");
                int numero = stdin.nextInt();
                out.println(numero);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutto_15_03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[]Args){

        Socket socket;

        try {
            socket = new Socket("localhost",12345);

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
            Scanner stdin = new Scanner(System.in);

            System.out.println(" Ingrese que desea hacer: ");
            String opcion = stdin.nextLine();

            if(opcion.equals("GET")){
                out.println(1);

                int cantidadFilas = in.nextInt();

                System.out.println("Hay de 0 a "+(cantidadFilas-1));

                int aux;

                while (cantidadFilas>0){

                    System.out.println("Numero de Fila...");

                    aux = stdin.nextInt();

                    out.println(aux);

                    cantidadFilas--;
                }

                int tamanoArray = in.nextInt();
                int[] arrayCodificado = new int [tamanoArray];
                for (int i = 0; i < arrayCodificado.length; i++) {
                    arrayCodificado[i]=in.nextInt();
                }

                int[] arrayDecodificado = decodificacion(arrayCodificado);

                for (int i = 0; i < arrayDecodificado.length; i++) {
                    System.out.print("| "+arrayDecodificado[i]+" |");
                }
            }else if (opcion.equals("POST")){

            }else{
                System.out.println("ERROR");
            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }

    }

    public static int[] decodificacion(int[]array){
        return null;
    }

}

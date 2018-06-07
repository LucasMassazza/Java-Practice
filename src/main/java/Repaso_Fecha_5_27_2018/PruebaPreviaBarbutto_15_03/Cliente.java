package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutto_15_03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[]Args){

        Socket socket = null;

        try {
            socket = new Socket("localhost",12345);

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner stdin = new Scanner(System.in);

            System.out.println(" Ingrese que desea hacer: ");
            String opcion = stdin.nextLine();

            if(opcion.equals("GET")){
                out.println(1);
                int cantidadFilas = in.nextInt();
                System.out.println("Hay de 0 a "+(cantidadFilas-1));
                int aux;
                out.println(cantidadFilas);
                while (cantidadFilas>0){
                    System.out.println("Numero de Fila...");
                    aux = stdin.nextInt();
                    out.println(aux);
                    cantidadFilas--;
                }
                int tamanoArray = in.nextInt();
                for (int i = 0; i < tamanoArray; i++) {
                    aux = in.nextInt();
                    System.out.print("| "+aux+" |");
                }















            }else if (opcion.equals("POST")){

                out.println(0);

                int cantidadColumnas = in.nextInt();

                System.out.println("Que fila desea sobreescribir...");

                int filaSobreescribir = stdin.nextInt();

                out.println(filaSobreescribir);

                int aux;

                for (int i = 0; i < cantidadColumnas; i++) {
                    System.out.println("Ingrese valor...");

                    aux=stdin.nextInt();

                    out.println(aux);
                }

                String confirmacion = in.nextLine();
                System.out.println(confirmacion);

            }else{
                System.out.println("ERROR");
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

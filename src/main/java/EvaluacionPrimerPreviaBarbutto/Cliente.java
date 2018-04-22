package EvaluacionPrimerPreviaBarbutto;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[]Args) throws Exception{

        Socket socket = new Socket("localhost",54321);


        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        Scanner stdin = new Scanner(System.in);

        int filas = in.nextInt();
        int columnas = in.nextInt();

        Matrix matriz = new Matrix(filas,columnas);

        System.out.println("Que desea hacer: ");
        String decision = stdin.nextLine();

        out.println(decision);
        out.flush();

        if(decision.equals("GET")){

            int []arrayCodificadoLLegado;
            int tamano=0;
            Descodificacion descodificacion;

            for (int i = 0; i < filas; i++) {

                tamano=in.nextInt();
                arrayCodificadoLLegado = new int[tamano];
                for (int j = 0; j < arrayCodificadoLLegado.length; j++) {
                    arrayCodificadoLLegado[j]=in.nextInt();
                }
                descodificacion = new Descodificacion(arrayCodificadoLLegado);

                descodificacion.start();
            }



        }else{
            System.out.println("Ingrese una opcion correcta \n \n Intente Nuevamente");
            return;
        }
    }
}

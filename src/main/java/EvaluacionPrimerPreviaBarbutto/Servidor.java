package EvaluacionPrimerPreviaBarbutto;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Servidor {

    public static void main(String[]Args) throws Exception{

        ServerSocket ss = new ServerSocket(54321);
        Socket socket;

        Handler handler;
        Matrix matriz = new Matrix(20,30);
        Semaphore [] barreraSemaforoPost = new Semaphore[matriz.getRows()];
        Semaphore [] barreraSemaforos = new Semaphore[matriz.getRows()];
        Semaphore [][] matrizSemaforos = new Semaphore[matriz.getRows()][matriz.getColumns()];


        for (int i = 0; i < barreraSemaforos.length; i++) {
            barreraSemaforos[i]=new Semaphore(1);
        }

        for (int i = 0; i < matrizSemaforos.length; i++) {
            for (int j = 0; j < matrizSemaforos[0].length; j++) {
                matrizSemaforos[i][j]=new Semaphore(1);
            }
        }

        while (true){
            socket = ss.accept();

            handler = new Handler(matriz,socket,barreraSemaforos,matrizSemaforos,barreraSemaforoPost);

            handler.start();
        }

    }

}

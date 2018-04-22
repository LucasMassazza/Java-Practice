package EvaluacionPrimerPreviaBarbutto;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Handler extends Thread{

    private Matrix matriz;
    private Socket socket;
    private Algoritmo algoritmo = new Algoritmo();
    private Semaphore[] barreraSemaforo;
    private Semaphore[] barreraSemaforoPost;
    private  Semaphore[][] matrizSemaforo;


    public Handler(Matrix matriz,Socket socket,Semaphore[] barreraSemaforo,Semaphore[][] matrizSemaforo,Semaphore[] barreraSemaforoPost){
        this.matriz=matriz;
        this.socket=socket;
        this.barreraSemaforo=barreraSemaforo;
        this.matrizSemaforo=matrizSemaforo;
        this.barreraSemaforoPost=barreraSemaforoPost;
    }


    @Override
    public void run(){

        try {

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner in = new Scanner(socket.getInputStream());

            out.println(matriz.getColumns());
            out.println();
            out.println(matriz.getRows());


            String decision = in.nextLine();

            if(decision.equals("GET")){

                int [] arrayCodificadoParaMandar;

                for (int i = 0; i < matriz.getRows(); i++) {
                    arrayCodificadoParaMandar=Codificacion(i);
                    for (int j = 0; j < arrayCodificadoParaMandar.length; j++) {
                        out.println(arrayCodificadoParaMandar.length);
                        out.println(arrayCodificadoParaMandar[j]);
                    }
                }


            }else if(decision.equals("POST")) {

                out.println(matriz.getColumns());

                int filaAModificar = in.nextInt();
                int num;
                barreraSemaforoPost[filaAModificar].acquire();
                for (int i = 0; i < matriz.getColumns(); i++) {

                    num = in.nextInt();

                    barreraSemaforo[filaAModificar].acquire();

                    matriz.set(filaAModificar,i,num);

                    barreraSemaforo[filaAModificar].release();
                }
                barreraSemaforoPost[filaAModificar].release();

            }else{

                out.println("Salio Mal Gato");

                return;
            }

        }catch (Exception e){

        }
    }

    public int VecesRepetidasNumero(int num){

        int vecesRepetidas=0;

        for (int i = 0; i < matriz.getRows(); i++) {
            for (int j = 0; j < matriz.getColumns(); j++) {
                if(matriz.get(i,j)==num){
                    vecesRepetidas++;
                }
            }

        }


        return vecesRepetidas;
    }

    public int[] Codificacion (int fila) throws Exception{

        int [] arrayCodificado;
        int vecesNumeroRepetido;
        List<Integer> listaYaCodificados = new ArrayList();
        List<Integer> listaCodificados = new ArrayList();

        barreraSemaforo[fila].acquire();

            for (int j = 0; j < this.matriz.getColumns(); j++)
                if (!listaYaCodificados.contains(matriz.get(fila, j))) {

                    vecesNumeroRepetido = VecesRepetidasNumero(matriz.get(fila, j));

                    if (vecesNumeroRepetido > 1) {
                        listaCodificados.add(matriz.get(fila, j));
                        listaCodificados.add(192 + vecesNumeroRepetido);
                    } else {
                        if (matriz.get(fila, j) >= 192) {
                            listaCodificados.add(matriz.get(fila, j));
                            listaCodificados.add(192);
                        } else {
                            listaCodificados.add(matriz.get(fila, j));
                        }
                    }
                }


        barreraSemaforo[fila].release();

            arrayCodificado = new int[listaCodificados.size()];
        for (int i = 0; i < listaCodificados.size(); i++) {
            arrayCodificado[i]=listaCodificados.get(i);
        }

          return arrayCodificado;
    }


}

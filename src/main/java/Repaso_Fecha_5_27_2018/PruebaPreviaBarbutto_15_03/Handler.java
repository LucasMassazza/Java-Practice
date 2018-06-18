package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutto_15_03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Handler extends Thread{

    private Socket socket;
    private Semaphore[] arraySemaforos;
    private int[][] matrizEnteros;
    private List<Integer> listaEnterosDescodificada = new ArrayList();
    private ObtenerFilas obtieneFilas;
    private Semaphore mutex = new Semaphore(1);
    private int control =0;
    private CountDownLatch espera;

    public Handler(){

    }

    public Handler(Socket socket,Semaphore[] arraySemaforos,int[][] matrizEnteros){
        this.arraySemaforos=arraySemaforos;
        this.matrizEnteros=matrizEnteros;
        this.socket=socket;
    }

    @Override
    public void run(){
        try{

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner in = new Scanner(socket.getInputStream());
            out.println(matrizEnteros[0].length);
            int opcion = in.nextInt();

            if(opcion==1){
                out.println(matrizEnteros.length);
                int cantidadFilas = in.nextInt();
                espera = new CountDownLatch(cantidadFilas);
                int aux;
                while (cantidadFilas>0){
                    aux=in.nextInt();
                    obtieneFilas = new ObtenerFilas(listaEnterosDescodificada,matrizEnteros,arraySemaforos,mutex,aux,espera);
                    obtieneFilas.start();
                    cantidadFilas--;
                }

                espera.await();

                int[] arrayDecodificado = new int[listaEnterosDescodificada.size()];

                for (int i = 0; i < arrayDecodificado.length; i++) {
                    arrayDecodificado[i]=listaEnterosDescodificada.get(i);
                }

                int[] arrayCodificado = codificacion(arrayDecodificado);

                out.println(arrayCodificado.length);

                for (int i = 0; i < arrayCodificado.length; i++) {
                    out.println(arrayCodificado[i]);
                }

            }else{

                out.println(matrizEnteros[0].length);
                int filaSobreescribir = in.nextInt();

                int[] arrayEntrantes = new int[matrizEnteros.length];

                for (int i = 0; i < matrizEnteros.length; i++) {
                    arrayEntrantes[i]=in.nextInt();
                }

                arraySemaforos[filaSobreescribir].acquire();
                for (int i = 0; i < matrizEnteros.length; i++) {
                    matrizEnteros[filaSobreescribir][i]=arrayEntrantes[i];
                }
                arraySemaforos[filaSobreescribir].release();

                out.println("OK");

            }

        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public int[] codificacion(int[]array){
        int[] arrayCodificado=null;
        List<Integer> listaCodificados = new ArrayList<Integer>();
        List yaCodificado = new ArrayList();

        int vecesRepite;


        for (int i = 0; i < array.length; i++) {
            if(!yaCodificado.contains(array[i])){
                vecesRepite=vecesRepte(array,array[i]);

                if(vecesRepite>1){
                    listaCodificados.add(array[i]);
                    listaCodificados.add(192+vecesRepite);
                }else{
                    if(array[i]<192){
                        listaCodificados.add(array[i]);
                    }else{
                        listaCodificados.add(array[i]);
                        listaCodificados.add(193);
                    }
                }


            }
        }


        arrayCodificado = new int[listaCodificados.size()];

        for (int i = 0; i < listaCodificados.size(); i++) {
            arrayCodificado[i]=listaCodificados.get(i);
        }

        return arrayCodificado;
    }

    public int vecesRepte(int[] array,int num){
        int veces =0;

        for (int i = 0; i < array.length; i++) {
            if(num==array[i]){
                veces++;
            }
        }

        return veces;
    }

}

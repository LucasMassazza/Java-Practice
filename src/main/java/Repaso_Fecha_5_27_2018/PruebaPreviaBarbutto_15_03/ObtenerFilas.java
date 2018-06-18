package Repaso_Fecha_5_27_2018.PruebaPreviaBarbutto_15_03;

import gherkin.lexer.Th;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ObtenerFilas extends Thread {

    private List<Integer> listaEnteros;
    private int[][] matrizEnteros;
    private Semaphore[] arraySemaforos;
    private Semaphore mutex;
    private int numeroFila;
    private CountDownLatch espera;

    public ObtenerFilas(List<Integer> listaEnteros,int[][] matrizEnteros,Semaphore[] arraySemaforos,Semaphore mutex,int numeroFila,CountDownLatch espera){
        this.mutex=mutex;
        this.arraySemaforos=arraySemaforos;
        this.matrizEnteros=matrizEnteros;
        this.listaEnteros=listaEnteros;
        this.numeroFila=numeroFila;
        this.espera=espera;
    }

    @Override
    public void run(){
        try {
            int aux;
           for (int i = 0; i < matrizEnteros[numeroFila].length; i++) {
                arraySemaforos[i].acquire();
                aux = matrizEnteros[numeroFila][i];
                arraySemaforos[i].release();

                mutex.acquire();
                listaEnteros.add(aux);
                mutex.release();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        espera.countDown();


    }

}

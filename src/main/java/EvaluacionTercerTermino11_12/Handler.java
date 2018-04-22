package EvaluacionTercerTermino11_12;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Handler extends Thread{

    private Socket socket;
    private Semaphore semaforoA;
    private Semaphore semaforoB;
    private Queue cola;
    private Cliente cliente = new Cliente();

    public Handler(Socket socket, Semaphore semaforoA, Semaphore semaforoB,Queue cola){
        this.socket=socket;
        this.semaforoA=semaforoA;
        this.semaforoB=semaforoB;
        this.cola=cola;
    }
    @Override
    public void run(){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner in = new Scanner(socket.getInputStream());

            String decision = in.nextLine();


            if(decision.equals("GET")){
                int cantidadNumeros = in.nextInt();
                System.out.println("YA");
                int [] arrayNumeros = new int[cantidadNumeros];
                int indice=0;
                while(indice<cantidadNumeros){
                    if(!cola.isEmpty()){
                        semaforoA.acquire();
                        if(!cola.isEmpty()){
                            arrayNumeros[indice] = cola.deQueue();
                            indice+=1;
                        }
                        semaforoA.release();
                    }
                }
                arrayNumeros = Codificacion(arrayNumeros);
                out.println(arrayNumeros.length);
                for (int i = 0; i < arrayNumeros.length; i++) {
                    out.println(arrayNumeros[i]);
                }
            }else if(decision.equals("POST")){

                int tamanoArray = in.nextInt();

                int[] arrayCodificao = new int[tamanoArray];

                for (int i = 0; i < arrayCodificao.length; i++) {
                    arrayCodificao[i]=in.nextInt();
                }



                int[] arrayDescodificado = cliente.Decodificacion(arrayCodificao);
                int indice=0;

                while (indice<arrayDescodificado.length){
                    if(!cola.isFull()){
                        semaforoA.acquire();
                        if(!cola.isFull()){
                            cola.queue(arrayDescodificado[indice]);
                            indice++;
                        }
                        semaforoA.release();
                    }
                }
                decision = "OK";
                out.println(decision);
            }else{
                return;
            }
        }catch (Exception e){
            System.out.println("Algun Error...");
        }finally {
            try {
                socket.close();
                System.out.println("Se cerro todo vieja");
            }catch (IOException e){

            }

        }
    }

    public int[] Codificacion(int[] arrayNumerosSinCodificar){

        List<Integer> listaYaCodificados = new ArrayList();
        List<Integer> listaNumerosCodificados = new ArrayList();
        int[] arrayYaCodificados;

        for (int i = 0; i < arrayNumerosSinCodificar.length; i++) {
            if(!listaYaCodificados.contains(arrayNumerosSinCodificar[i])){

                if(VecesRepiteNumero(arrayNumerosSinCodificar,arrayNumerosSinCodificar[i])>1&&VecesRepiteNumero(arrayNumerosSinCodificar,arrayNumerosSinCodificar[i])<63){
                    listaNumerosCodificados.add(arrayNumerosSinCodificar[i]);
                    listaNumerosCodificados.add(192+VecesRepiteNumero(arrayNumerosSinCodificar,arrayNumerosSinCodificar[i]));
                    listaYaCodificados.add(arrayNumerosSinCodificar[i]);
                }else if(VecesRepiteNumero(arrayNumerosSinCodificar,arrayNumerosSinCodificar[i])==1){

                    if(VecesRepiteNumero(arrayNumerosSinCodificar,arrayNumerosSinCodificar[i])<192){
                        listaNumerosCodificados.add(arrayNumerosSinCodificar[i]);
                    }else{
                        listaNumerosCodificados.add(arrayNumerosSinCodificar[i]);
                        listaNumerosCodificados.add(192+VecesRepiteNumero(arrayNumerosSinCodificar,arrayNumerosSinCodificar[i]));
                    }

                }

            }
        }

        arrayYaCodificados = new int[listaNumerosCodificados.size()];

        for (int i = 0; i < arrayYaCodificados.length; i++) {
            arrayYaCodificados[i]=listaNumerosCodificados.get(i);
        }

        return arrayYaCodificados;
    }

    public int VecesRepiteNumero (int[] array,int num){
        int vecesRepite=0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]==num){
                vecesRepite++;
            }
        }

        return vecesRepite;
    }


}

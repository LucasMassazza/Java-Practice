package EvaluacionTercerTermino11_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] Args)throws Exception{

        Socket socket = new Socket("localhost",65432);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),false);
        Scanner in = new Scanner(socket.getInputStream());
        BufferedReader inString = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner stdin = new Scanner(System.in);

        Cliente a = new Cliente();

        String decision = "";

        System.out.println("Que desea Hacer (GET o POST): ");
        decision = stdin.nextLine();
        out.println(decision);


        if(decision.equals("GET")){
            System.out.println("Ingrese Cantidad de valores: ");

            int cantidadNumeros = stdin.nextInt();
            int num;

            out.println(cantidadNumeros);
            int interespacio=0;

            out.flush();

            int cantidadNumerosArray = in.nextInt();

            int[] arrayCodificado = new int[cantidadNumerosArray];

            for (int i = 0; i < arrayCodificado.length; i++) {
                arrayCodificado[i]=in.nextInt();
            }

            int[] arrayDecodificado = a.Decodificacion(arrayCodificado);

            for (int i = 0; i < arrayDecodificado.length; i++) {
                System.out.print("|"+arrayDecodificado[i]+"|");
                interespacio++;
                if(interespacio==5){
                    System.out.println("\n");
                    interespacio=0;
                }
            }
        }else if(decision.equals("POST")){
            System.out.println("Cuantos numeros desea Ingresar: ");

            int numerosAIngresar = stdin.nextInt();

            int[] arrayNumeros = new int[numerosAIngresar];

            System.out.println("Ingrese los numeros...");

            for (int i = 0; i < arrayNumeros.length; i++) {
                arrayNumeros[i]=stdin.nextInt();
            }
            int[] arrayNumerosCodificados = a.Codificacion(arrayNumeros);

            out.println(arrayNumerosCodificados.length);

            for (int i = 0; i < arrayNumerosCodificados.length; i++) {
                out.println(arrayNumerosCodificados[i]);
            }

            out.flush();

            String confirmacion = inString.readLine();

            System.out.println(confirmacion);

        }else{
            System.out.println("Igresaste mal... BOLUDO ERAN SOLO DOS OPCIONES... Salio tonto el nene...");
        }


    }

    public int[] Decodificacion(int[] arrayCodificado){

        int[] arrayDecodificado;
        List<Integer> listaDecodificada = new ArrayList();

        for (int i = 0; i < arrayCodificado.length;) {
            if (arrayCodificado[i]<192) {
                listaDecodificada.add(arrayCodificado[i]);
                i++;
            }else{
                for (int j = 0; j < arrayCodificado[i] - 192; j++) {
                    listaDecodificada.add(arrayCodificado[i+1]);
                }

                i+=2;
            }
        }

        arrayDecodificado = new int[listaDecodificada.size()];

        for (int i = 0; i < arrayDecodificado.length; i++) {
            arrayDecodificado[i]=listaDecodificada.get(i);
        }

        return arrayDecodificado;
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

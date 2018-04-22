package EvaluacionPrimerPreviaBarbutto;

import java.util.ArrayList;

public class Algoritmo {




    public ArrayList Codificacion(Matrix matriz, int fila){
        ArrayList listaCodificada = new ArrayList();
        ArrayList numeroCodificados = new ArrayList();

        int VecesRepetida = 0;


        for (int i = 0; i < matriz.getColumns(); i++) {

            VecesRepetida=0;
            if(!FueCodificado(listaCodificada,matriz.get(fila,i))){

                for (int j = 0; j < matriz.getColumns(); j++) {

                    if (matriz.get(fila,j)==matriz.get(fila,i)){
                        VecesRepetida+=1;
                    }

                }

                if(VecesRepetida>1){

                    listaCodificada.add(matriz.get(fila,i));
                    listaCodificada.add(192+VecesRepetida);

                }else if(VecesRepetida==1){

                    if(matriz.get(fila,i)<192){

                        listaCodificada.add(matriz.get(fila,i));

                    }else{

                        listaCodificada.add(matriz.get(fila,i));
                        listaCodificada.add(192);

                    }

                }

            }

        }

        return listaCodificada;
    }

    public Matrix Decodificacion(Matrix matriz){
        Matrix newMatriz = matriz;



        return newMatriz;
    }


    public boolean FueCodificado(ArrayList lista,int num){

        if(lista.contains(num)){
            return true;
        }

        return false;
    }



}

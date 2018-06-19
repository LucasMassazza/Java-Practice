package PruebaPreviaBarbutto_31_05_2018.Ejercicio1;

public class Compactar {

    public int[] colapsar(int[] array){

        int indiceDeColapso = 0;

        for (int i = 0; i < array.length-1; i++) {

            if (array[i]==array[i+1] && array[i]!=-1){
                array[i]=array[i]+array[i];
                array[i+1]=-1;
                indiceDeColapso++;

                mover(array,i+1);

            }

        }


        return array;
    }

    public int[] mover (int[] array,int indiceDeColapso){

        int aux;

        for (; indiceDeColapso < array.length -1; indiceDeColapso++) {
            if(array[indiceDeColapso]!=array[indiceDeColapso+1]){
                aux=array[indiceDeColapso+1];
                array[indiceDeColapso+1]=array[indiceDeColapso];
                array[indiceDeColapso]=aux;
            }else{
                return array;
            }


        }

        return array;

    }

}

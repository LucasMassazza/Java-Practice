package PruebaPreviaBarbutto_31_05_2018.Ejercicio4;

public class Cola {

    private int [] array;
    private int indice;

    public Cola (int tamano){
        array = new int[tamano];
        indice=0;
    }

    public void sumarIndice(){
        indice++;
    }

    public void restarIndice(){ indice--; }

    public boolean lleno(){

        if(indice==array.length-1){
            return true;
        }

        return false;
    }

    public int tamanoArray(){
        return array.length;
    }

    public int getArray(int indice){
        return array[indice];
    }

    public  void ingresarArray(int numero){

        int aux;

        array[indice]=numero;

        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j]>array[j+1]){
                    aux = array[j+1];
                    array[j+1]=array[j];
                    array[j]=aux;
                }
            }
        }

    }

    public void volverACeroIndice(){
        indice=0;
    }



}

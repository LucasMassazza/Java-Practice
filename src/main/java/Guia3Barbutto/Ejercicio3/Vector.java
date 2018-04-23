package Guia3Barbutto.Ejercicio3;

public class Vector{
    
    private double[] vector;
    
    public Vector(int coordinates){
        vector = new double[coordinates];
    }

    public Vector(double[] coordinates){
        this.vector=coordinates;
    }
    
    public double getCoordinate(int index){
        return vector[index];
    }
    
    public double norm(){
        double normaVector = 0;
        double acumulador = 0;

        for (int i = 0; i < vector.length; i++) {
            acumulador+=Math.pow(this.vector[i],2);
        }

        normaVector = Math.sqrt(acumulador);
        
        return normaVector;
    }

    public Vector add(Vector aVector){
        Vector newVector = null;
        double[] coordinates = new double[this.vector.length];

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i]=this.getCoordinate(i)+aVector.getCoordinate(i);
        }

        newVector = new Vector(coordinates);

        return newVector;
    }

    public double dotProduct(Vector aVector){
        double produtoEscalar = 0;

        for (int i = 0; i < this.vector.length; i++) {
            produtoEscalar+=this.getCoordinate(i)* aVector.getCoordinate(i);
        }

        return produtoEscalar;
    }

    
    
}

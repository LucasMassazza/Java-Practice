package Guia3Barbutto.Ejercicio2;

public class Vector3D {

    private double[] arrayTridimensional;

    public Vector3D(double x,double z,double y){
        arrayTridimensional = new double[3];
        arrayTridimensional[0]=x;
        arrayTridimensional[1]=y;
        arrayTridimensional[2]=z;
    }

    public Vector3D(){
        arrayTridimensional = new double[3];
        arrayTridimensional[0]=0;
        arrayTridimensional[1]=0;
        arrayTridimensional[2]=0;
    }

    public double getX(){
        return arrayTridimensional[0];
    }

    public double getY(){
        return arrayTridimensional[1];
    }

    public double getZ() {
        return arrayTridimensional[2];
    }

    public double norm(){
        return Math.sqrt((Math.pow(arrayTridimensional[0],2)+Math.pow(arrayTridimensional[1],2)+Math.pow(arrayTridimensional[2],2)));
    }

    public Vector3D add(Vector3D aVector){
        Vector3D newVector3D = new Vector3D((this.getX()+aVector.getX()),(this.getY()+aVector.getY()),(this.getZ()+aVector.getZ()));
        return newVector3D;
    }

    public double dotProduct (Vector3D aVector){

        double productoEscalar = 0;

        productoEscalar+=this.getX()+aVector.getX();
        productoEscalar+=this.getY()+aVector.getY();
        productoEscalar+=this.getZ()+aVector.getZ();

        return productoEscalar;
    }


}

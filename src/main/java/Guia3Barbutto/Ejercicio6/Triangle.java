package Guia3Barbutto.Ejercicio6;

import Guia3Barbutto.Ejercicio1.Point;

public class Triangle {

    private double base;
    private double altura;
    private Point origen;

    public Triangle(Point origen,double base, double altura){
        this.altura=altura;
        this.base=base;
        this.origen=origen;
    }

    public Triangle(double base, double altura){
        origen = new Point(0,0);
        this.base=base;
        this.altura=altura;
    }

    public double getArea(){
        return (base*altura)/2;
    }

    public double getPerimeter(){
        return 0;
    }

    public Point[] getVertices(){
        Point[] vertices = new Point[3];
        vertices[0]=origen;
        vertices[1]=new Point(this.origen.getX(),(this.origen.getY()+this.altura));
        vertices[2]=new Point((this.origen.getX()+this.base),this.origen.getY());
        return vertices;
    }

    public Point getVertex(int indice){

        return getVertices()[indice];

    }
}

package Guia3Barbutto.Ejercicio4;

import Guia3Barbutto.Ejercicio1.Point;

public class Circle {

    private Point center;
    private double radio;

    public Circle(Point center,double radio){
        this.center=center;
        this.radio=radio;
    }

    public double getArea(){return Math.PI*(Math.pow(radio,2));}

    public Point origen(){return center;}

    public double getRadius(){
        return radio;
    }

    public double getPerimeter(){
        return Math.PI*(radio*2);
    }
}

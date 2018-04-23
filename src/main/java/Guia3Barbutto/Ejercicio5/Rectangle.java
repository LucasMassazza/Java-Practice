package Guia3Barbutto.Ejercicio5;

import Guia3Barbutto.Ejercicio1.Point;

public class Rectangle {

    private Point origen;
    private double base;
    private double altura;

    public Rectangle(Point origen,double base,double altura){
        this.origen=origen;
        this.base=base;
        this.altura=altura;
    }

    public double getArea(){
        return base*altura;
    }

    public Point getOrigen(){
        return origen;
    }

    public Point getCorner(){
        Point newPoint = null;

        if(altura>0){
            newPoint=new Point((this.getOrigen().getX()+base),0);
        }else{
            newPoint=new Point((this.getOrigen().getX()+base),(this.origen.getY()+altura));
        }

        return newPoint;
    }

    public double getPerimeter(){
        return (base*2)+(altura*2);
    }


}

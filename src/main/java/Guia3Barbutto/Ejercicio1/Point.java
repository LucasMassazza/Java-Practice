package Guia3Barbutto.Ejercicio1;

public class Point {

    private double x;
    private double y;

    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }


    public Point(){
        y=0;
        x=0;
    }

    public Point add(Point point){
        Point newPoint = new Point(this.x+point.getX(),this.getY()+this.y);
        return newPoint;
    }

    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }



}

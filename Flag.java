import java.awt.*;
import java.util.*;

/**
 * Class constructor of Flag of the GoingMerry, implements DrawingObject interface
 * 
 * Uses Line, Circle, Rectangle and SemiCircle classes as well
 * 
 * Makes the flag of the straw hat pirates
 * 
 * @author Gabriel L. Salvador (225593)
 * @version March 9, 2023
 */

/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.
I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/

public class Flag implements DrawingObject{

    private double x;
    private double y;
    private double angle;
    private ArrayList<Color> colors;

    public Flag(double x, double y, ArrayList<Color> colors){
        this.x = x;
        this.y = y;
        angle = 0;
        this.colors = colors;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();
        
        shapes.add(new Rectangle(x,y,67,50,colors.get(6)));
        
        shapes.add(new Circle(x+12,y+7,6,Color.white));
        shapes.add(new Circle(x+10,y+10,6,Color.white));
        shapes.add(new Circle(x+48,y+7,6,Color.white));
        shapes.add(new Circle(x+51,y+10,6,Color.white));
        shapes.add(new Circle(x+12,y+36,6,Color.white));
        shapes.add(new Circle(x+10,y+33,6,Color.white));
        shapes.add(new Circle(x+48,y+36,6,Color.white));
        shapes.add(new Circle(x+51,y+33,6,Color.white));

        shapes.add(new Line(x+15,y+12,x+52,y+38,4,Color.white));
        shapes.add(new Line(x+15,y+38,x+52,y+12,4,Color.white));


        shapes.add(new SemiCircle(x+24,y+9,20,0,Color.YELLOW));
        shapes.add(new SemiCircle(x+24,y+11,20,180,Color.white));
        shapes.add(new Rectangle(x+27.5,y+28,13,9,Color.white));

        shapes.add(new Circle(x+27,y+21,5,colors.get(6)));
        shapes.add(new Circle(x+35,y+21,5,colors.get(6)));
        shapes.add(new Circle(x+32,y+25,3,colors.get(6)));
        
        shapes.add(new SemiCircle(x+27.5,y+32,13,180,Color.white));
        
        shapes.add(new Line(x+28,y+34,x+41,y+34,1,colors.get(6)));

        for( int i = 0; i < 3; i++){
            for (int j = 0; j < 2; j++){
                shapes.add(new Line(x+30+4*i,y+31+3*j,x+30+4*i,y+34+3*j,1,colors.get(6)));
            }
        }
        shapes.add(new Arc(x+24,y+11,20,180,180,1,colors.get(6)));
        shapes.add(new Line(x+25,y+18,x+43,y+18,2,Color.red));
        shapes.add(new Line(x+19,y+20,x+49,y+20,2,Color.YELLOW));

        for (DrawingObject s : shapes){
            s.draw(g2d);
        }

        shapes.clear(); //Prevents duplicate frames
    }

    @Override
    public double getX(){
        return x;
    }
    
    @Override 
    public double getY(){
        return y;
    }

    @Override 
    public double getAngle(){
        return angle;
    }

    @Override
    public void adjustX(double distance){
        x += distance;
    }

    @Override 
    public void adjustY(double distance){
        y += distance;
    }
    
    @Override
    public void adjustAngle(double degree){
        angle += degree;
    }
}
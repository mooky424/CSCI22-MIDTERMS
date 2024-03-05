import java.awt.*;
import java.util.*;

/**
 * Class constructor of Stern (back of the ship) of the Going Merry, implements DrawingObject interface
 * 
 * Uses Curved Triangle, Rectangle, Line, Circle, SemiCircle, Flag, and Oval classes
 * 
 * Makes the back part of the ship
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

public class Stern implements DrawingObject{
    
    private double x;
    private double y;
    private ArrayList<Color> colors;
    private double angle;

    public Stern(double x, double y, ArrayList<Color> colors){
        this.x = x;
        this.y = y;
        angle = 0;
        this.colors = colors;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();
        
        //Base
        shapes.add(new CurvedTriangle(x+80, y, 0, 0, x, y, 8, -30, x+80, y+150, colors.get(0)));
        shapes.add(new Rectangle(x+79, y, 120, 150, colors.get(0)));

        //Net
        for(int i = 0; i<4; i++){
            shapes.add(new Line(x+140+(i*15),y+5,x+258,y-275,1,colors.get(7)));
            for(int j = 1; j<=10; j++){
                shapes.add(new Line(x+140+(j*0.4214219*20), y+5-(20*j), x+185+(j*.260714*20), y+5-(20*j),1,colors.get(7)));
            }
        }

        //Cannon
        shapes.add(new Rectangle(x+100,y+20,40,30,colors.get(13)));
        shapes.add(new Rectangle(x+104,y+24,32,22,Color.black));
        shapes.add(new Circle(x+109,y+24,22,colors.get(13)));
        shapes.add(new Circle(x+113,y+28,14,Color.black));
        
        //Flag
        shapes.add(new Rectangle(x+40, y-220, 10, 220, colors.get(8)));
        shapes.add(new Flag(x+48,y-215,colors));
        
        //Mast
        shapes.add(new Line(x+20,y,x+49,y-169,1,colors.get(7)));
        shapes.add(new Line(x+90,y,x+49,y-169,1,colors.get(7)));
        shapes.add(new Line(x,y,x+41,y-60,1,colors.get(7)));
        shapes.add(new CurvedTriangle(x+45, y-170, 25, 20, x+40, y-60, 70, 20, x+45, y-170, colors.get(5)));
        
        //Rudder
        shapes.add(new SemiCircle(x-50, y+40, 120,280, colors.get(0)));
        
        //Brace
        shapes.add(new Triangle(x+65, y+49, x+40, y+49, x+60, y+85, colors.get(2)));
        shapes.add(new Rectangle(x+59, y+49, 140, 35, colors.get(2)));
        
        //Cabin
        shapes.add(new Oval(x+80, y-110, 40,80, colors.get(3)));
        shapes.add(new Oval(x+110, y-100, 50,70, colors.get(3)));
        shapes.add(new Rectangle(x+80,y-50,80,50,colors.get(9)));
        shapes.add(new Circle(x+93,y-37,20,colors.get(12)));
        shapes.add(new Circle(x+95,y-35,16,colors.get(11)));
        shapes.add(new Circle(x+123,y-37,20,colors.get(12)));
        shapes.add(new Circle(x+125,y-35,16,colors.get(11)));
        
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

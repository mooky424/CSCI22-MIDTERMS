import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Class constructor of Bow (front of ship) of the Going Merry, implements DrawingObject interface
 * 
 * Uses Area.intersect method to make custom shapes
 * 
 * Uses Line and Quarter Circle classes as well
 * 
 * Makes the front part of the ship
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

public class Bow implements DrawingObject{

    private double x;
    private double y;
    private ArrayList<Color> colors;
    private double angle;

    public Bow(double x, double y, ArrayList<Color> colors){
        this.x = x;
        this.y = y;
        this.colors = colors;
        angle = 0;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();
        
        //base
        Arc2D.Double bow = new Arc2D.Double(x+167,y-150,300,300,270,90,Arc2D.PIE);
        g2d.setColor(colors.get(0));
        g2d.fill(bow);

        //brace
        Area brace = new Area(new Rectangle2D.Double(x+167,y+49,300,35));
        brace.intersect(new Area(bow));
        g2d.setColor(colors.get(2));
        g2d.fill(brace);
        
        //rope        
        shapes.add(new Line(x+457,y+8,x+258,y-240,1,colors.get(7)));

        for(DrawingObject s : shapes){
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
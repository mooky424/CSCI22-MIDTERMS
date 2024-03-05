import java.awt.*;
import java.util.*;

/**
 * Class constructor of Hull (middle of ship) of the Going Merry, implements DrawingObject interface
 * 
 * Uses Rectangle class
 * 
 * Makes the middle part of the ship
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

public class Hull implements DrawingObject{
    
    private double x;
    private double y;
    private double angle;
    private ArrayList<Color> colors;
    ArrayList<DrawingObject> shapes;

    public Hull(double x, double y, ArrayList<Color> colors){
        this.x = x;
        this.y = y;
        angle = 0;
        this.colors = colors;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        shapes = new ArrayList<DrawingObject>();
        
        shapes.add(new Rectangle(x+198, y+40, 120, 110, colors.get(0)));
        shapes.add(new Rectangle(x+197, y+49, 122, 35, colors.get(2)));
        
        for (DrawingObject s : shapes){
            s.draw(g2d);
        }
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

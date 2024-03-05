import java.awt.*;
import java.util.*;

/**
 * Class constructor of Wave, implements DrawingObject interface
 *  
 * Uses Rectangle and Curved Triangle classes
 * 
 * Makes waves using specified color
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

public class Wave implements DrawingObject{

    private double x;
    private double y;
    private Color color;
    private double angle;
    ArrayList<DrawingObject> shapes;

    public Wave(double x, double y, Color color){
        this.x = x;
        this.y = y;
        angle = 0;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        shapes = new ArrayList<DrawingObject>();

        for(int i = 0; i <12; i++){
            shapes.add(new Rectangle(x+100*i, y+29, 120, 300, color));
            shapes.add(new CurvedTriangle(
                x+100*i, y+30, 
                10, 15, 
                x+60+100*i, y, 
                -10, 15, 
                x+120+100*i, y+30, 
                color));
        }
        
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
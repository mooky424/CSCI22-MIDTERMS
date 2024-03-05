import java.awt.*;
import java.awt.geom.*;

/**
 * Class constructor for QuarterCircle, implements DrawingObject interface
 * 
 * Uses Arc2D.Double class of java.awt.geom
 * 
 * Makes a quarter circle with specified size and color
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

public class QuarterCircle implements DrawingObject{

    private double x;
    private double y;
    private double size;
    private double rotation;
    private double angle;
    private Color color;
    
    public QuarterCircle(double x, double y, double size, double rotation, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.rotation = rotation;
        angle = 0;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d){
        Arc2D.Double quartercircle = new Arc2D.Double(x,y,size,size,rotation,90,Arc2D.PIE);
        g2d.setColor(color);
        g2d.fill(quartercircle);
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
import java.awt.*;
import java.awt.geom.*;

/**
 * Class constructor for SemiCircle, implements DrawingObject interface
 * 
 * Uses Arc2D.Double class of java.awt.geom
 * 
 * Makes a semi circle with specified size and color
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

public class SemiCircle implements DrawingObject{

    private double x;
    private double y;
    private double size;
    private double startAngle;
    private Color color;

    public SemiCircle(double x, double y, double size, double startAngle, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.startAngle = startAngle;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Arc2D.Double semicircle = new Arc2D.Double(x,y,size,size,startAngle,180,Arc2D.PIE);
        g2d.setColor(color);
        g2d.fill(semicircle);
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
        return startAngle;
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
        startAngle += degree;
    }
}
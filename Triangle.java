import java.awt.*;
import java.awt.geom.*;

/**
 * Class constructor of Triangle, implements DrawingObject interface
 * 
 * Uses Path2D.Double class of java.awt.geom
 * 
 * Uses lineTo method for the sides
 * 
 * Makes a triangle with three points and the specified color
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

public class Triangle implements DrawingObject{
    
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;
    private double angle;
    private Color color;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        angle = 0;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.closePath();
        g2d.setColor(color);
        g2d.fill(triangle);
    }

    @Override
    public double getX(){
        return x1;
    }

    @Override
    public double getY(){
        return y1;
    }

    @Override
    public double getAngle(){
        return angle;
    }

    @Override
    public void adjustX(double distance){
        x1 += distance;
        x2 += distance;
        x3 += distance;
    }

    @Override
    public void adjustY(double distance){
        y1 += distance;
        y2 += distance;
        y3 += distance;
    }

    @Override
    public void adjustAngle(double degree){
        angle += degree;
    }
}

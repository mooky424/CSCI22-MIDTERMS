import java.awt.*;
import java.awt.geom.*;

/**
 * Class constructor of Curved Triangle, implements DrawingObject interface
 * 
 * Uses Path2D.Double class of java.awt.geom
 * 
 * Uses lineTo method for straight lines and quadTo for curved lines
 * 
 * Makes a triangle with curved sides using three points, the offsets given, and the specified color
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

public class CurvedTriangle implements DrawingObject{
    
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;
    private double xOffset1;
    private double yOffset1;
    private double xOffset2;
    private double yOffset2;
    private double angle;
    private Color color;

    public CurvedTriangle(double x1, double y1, double xOffset1, double yOffset1,double x2, double y2, double xOffset2, double yOffset2, double x3, double y3, Color color){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.xOffset1 = xOffset1;
        this.yOffset1 = yOffset1;
        this.xOffset2 = xOffset2;
        this.yOffset2 = yOffset2;
        angle = 0;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        Path2D.Double stern = new Path2D.Double();
        stern.moveTo(x1, y1);
        stern.quadTo((x1+x2)/2+xOffset1,(y1+y2)/2+yOffset1,x2, y2);
        stern.quadTo((x2+x3)/2+xOffset2, (y2+y3)/2+yOffset2, x3, y3);
        stern.closePath();
        g2d.setColor(color);
        g2d.fill(stern);
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
        xOffset1 += distance;
        xOffset2 += distance;
    }

    @Override
    public void adjustY(double distance){
        y1 += distance;
        y2 += distance;
        y3 += distance;
        yOffset1 += distance;
        yOffset2 += distance;
    }

    @Override
    public void adjustAngle(double degree){
        angle += degree;
    }
}

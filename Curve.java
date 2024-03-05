import java.awt.*;
import java.awt.geom.*;

/**
 * Class constructor of Curve, implements DrawingObject interface
 * 
 * Uses QuadCurve2D.Double class of java.awt.geom
 * 
 * Makes a spline curve using 4 points
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

public class Curve implements DrawingObject{
    
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double xControl;
    private double yControl;
    private int thickness;
    private double angle;
    private Color color;

    public Curve(double x1, double y1, double x2, double y2, double xControl, double yControl, int thickness, Color color){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.xControl = xControl;
        this.yControl = yControl;
        this.thickness = thickness;
        angle = 0;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        QuadCurve2D.Double curve = new QuadCurve2D.Double(x1,y1,xControl,yControl,x2,y2);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(color);
        g2d.draw(curve);
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
        xControl += distance;
    }

    @Override
    public void adjustY(double distance){
        y1 += distance;
        y2 += distance;
        yControl += distance;
    }

    @Override
    public void adjustAngle(double degree){
        angle += degree;
    }
}

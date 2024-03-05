import java.awt.*;
import java.util.*;

/**
 * Class constructor of Cloud, implements DrawingObject interface
 *  
 * Uses Circle and Oval classes
 * 
 * Makes 3 variations of clouds in the specified color
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

public class Cloud implements DrawingObject{

    private double x;
    private double y;
    private Color color;
    private int variant;
    private double angle;
    private ArrayList<DrawingObject> shapes;

    public Cloud(double x, double y, int variant, Color color){
        this.x = x-100;
        this.y = y;
        this.color = color;
        this.variant = variant;
        angle = 0;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        shapes = new ArrayList<DrawingObject>();

        switch (variant){
            case 0:
                shapes.add(new Oval(x, y, 300, 35, Color.decode("#86e9fc")));
                shapes.add(new Oval(x, y, 300, 30, color));
                shapes.add(new Circle(x+93, y-126, 150, Color.decode("#86e9fc")));
                shapes.add(new Circle(x+90, y-120, 148, color));
                shapes.add(new Circle(x+42, y-67, 88, Color.decode("#86e9fc")));
                shapes.add(new Circle(x+40, y-65, 90, color));
                shapes.add(new Circle(x+212, y-48, 72, Color.decode("#86e9fc")));
                shapes.add(new Circle(x+210, y-50, 70, color));
                break;
            case 1:
                shapes.add(new Oval(x,y,103,18,Color.decode("#86e9fc")));
                shapes.add(new Circle(x+38,y-70,80,Color.decode("#86e9fc")));
                shapes.add(new Oval(x,y,100,15,color));
                shapes.add(new Circle(x+35,y-70,80,color));
                shapes.add(new Circle(x+19,y-36,38,Color.decode("#86e9fc")));
                shapes.add(new Circle(x+15,y-35,40,color));
                break;
            case 2:
                shapes.add(new Oval(x,y,203,24,Color.decode("#86e9fc")));
                shapes.add(new Circle(x+24,y-80,100,Color.decode("#86e9fc")));
                shapes.add(new Circle(x+103,y-30,40,Color.decode("#86e9fc")));
                shapes.add(new Circle(x+20,y-80,100,color));
                shapes.add(new Circle(x+100,y-30,40,color));
                shapes.add(new Oval(x,y,200,20,color));
                break;
        }
        

        
        for(DrawingObject s : shapes){
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
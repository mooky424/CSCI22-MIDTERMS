import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Class constructor of GoingMerry, implements DrawingObject interface
 * 
 * Uses the Ster, Hull, Bow, and Details 
 * 
 * draw method has a Color ArrayList that contains custom colors used in various parts of the ship
 * 
 * Makes the ship
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

public class GoingMerry implements DrawingObject {

    private double x;
    private double y;
    private double angle;
    ;
    ArrayList<Color> colors;

    public GoingMerry(double x, double y){
        this.x = x;
        this.y = y;
        angle = 0;
        
        colors = new ArrayList<Color>();

        colors.add(Color.decode("#ae825a")); //0 base
        colors.add(Color.decode("#ecf1e9")); //1 accent
        colors.add(Color.decode("#4d4d4d")); //2 brace
        colors.add(Color.decode("#308b38")); //3 bush
        colors.add(Color.decode("#cabea9")); //4 mast
        colors.add(Color.decode("#9c2325")); //5 mast2
        colors.add(Color.decode("#000203")); //6 flag
        colors.add(Color.decode("#382a26")); //7 rope
        colors.add(Color.decode("#cfaa77")); //8 poles
        colors.add(Color.decode("#8d765f")); //9 cabin
        colors.add(Color.decode("#adb6c5")); //10 spiral
        colors.add(Color.decode("#94e2d6")); //11 window
        colors.add(Color.decode("#b5a772")); //12 frame
        colors.add(Color.decode("#6f554e")); //13 window + cannon
        colors.add(Color.decode("#62493a")); //14 Rings
        colors.add(Color.decode("#a28d82")); //15 horn
        colors.add(Color.decode("#695048")); //16 horn spiral
    }

    public void draw(Graphics2D g2d){   

        ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();

        AffineTransform reset = g2d.getTransform();
        g2d.rotate(Math.toRadians(angle),x+258,y+534);

        shapes.add(new Stern(x, y+460.8, colors));       
        shapes.add(new Bow(x, y+460.8, colors));
        shapes.add(new Hull(x, y+460.8, colors));
        shapes.add(new Mast(x, y, colors));
        shapes.add(new Details(x, y+460.8, colors));

        for (DrawingObject s : shapes){
            s.draw(g2d);
        }

        shapes.clear(); //Prevents duplicate frames        
        g2d.setTransform(reset);
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

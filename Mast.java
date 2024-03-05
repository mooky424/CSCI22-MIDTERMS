import java.awt.*;
import java.util.*;

/**
 * Class constructor of Mast (and sail) of the Going Merry, implements DrawingObject interface
 * 
 * Uses Rectangle, Triangle, and Curved Triangle classes
 * 
 * Makes the mast and sail of the ship
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

public class Mast implements DrawingObject{
    
    private double x;
    private double y;
    private ArrayList<Color> colors;
    private double angle;

    public Mast(double x, double y, ArrayList<Color> colors){
        this.x = x;
        this.y = y;
        angle = 0;
        this.colors = colors;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();
        
        //Pole
        shapes.add(new Rectangle(x+243, y+350.8, 30, 150, colors.get(0)));
        shapes.add(new Rectangle(x+248, y+230.8, 20, 150, colors.get(0)));
        shapes.add(new Rectangle(x+253, y+110.8, 10, 150, colors.get(0)));

        //Rings
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 5; j++){
                shapes.add(new Rectangle(x+242+5*i, y+470.8-(30*j)-(150*i), 32-10*i, 10, colors.get(14)));
            }
        }
        for (int i =0; i < 5; i++){
            shapes.add(new Rectangle(x+252,y+230.8-(30*i),12,10,colors.get(14)));
        }

        //Crow's Nest
        shapes.add(new Rectangle(x+230, y+185.8, 55, 30, colors.get(0)));
        shapes.add(new Triangle(x+231, y+185.8, x+218, y+185.8, x+231, y+215.8, colors.get(0)));
        shapes.add(new Triangle(x+284, y+185.8, x+298, y+185.8, x+285, y+215.8, colors.get(0)));
        shapes.add(new Rectangle(x+230, y+215.8, 55, 2, colors.get(14)));
        shapes.add(new Rectangle(x+218, y+185.8, 80, 2, colors.get(14)));
        
        //Flag
        shapes.add(new Flag(x+262,y+115.8,colors));

        //Sail
        shapes.add(new CurvedTriangle(x+258,y+220.8,80,70,x+220,y+460.8,160,90,x+258,y+220.8,colors.get(4)));

        for (DrawingObject s : shapes){
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
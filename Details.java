import java.awt.*;
import java.util.*;

/**
 * Class constructor of Details (details of ship) of the Going Merry, implements DrawingObject interface
 * 
 * Uses Area.intersect method to make custom shapes
 * 
 * Uses Line, Arc, Curve, and Circle classes as well
 * 
 * Makes the details of the ship (i.e. trim, bannisters, spirals, etc.)
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

public class Details implements DrawingObject{

    private double x;
    private double y;
    private double angle;
    private ArrayList<Color> colors;

    public Details(double x, double y, ArrayList<Color> colors){
        this.x = x;
        this.y = y;
        angle = 0;
        this.colors = colors;
    }
    
    @Override
    public void draw(Graphics2D g2d){

        ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();
        
        //Bow Trim + Details
        shapes.add(new Line(x+322, y+5, x+466, y+5, 10, colors.get(1)));        
        shapes.add(new Arc(x+167, y-150, 300, 275, 83, 4, colors.get(1)));
        
        //Bow Bannisters
        shapes.add(new Line(x+371, y-18, x+469, y-18, 6, colors.get(1)));
        for(int i = 0; i<6; i++){ //bannister columns
            shapes.add(new Line(x+387+(16*i),y-18, x+387+(16*i) ,y,4,colors.get(1)));
        }
        shapes.add(new Line(x+371, y-16, x+371, y, 6, colors.get(1)));
        shapes.add(new Circle(x+353,y-30,20,colors.get(1)));

        //Merry Figurehead
        shapes.add(new Oval(x+525, y-80, 60,50,colors.get(1)));
        shapes.add(new CubicCurve(x+372, y+10, x+562, y-57, x+486, y+148, x+430, y-100, 14, colors.get(1)));
        shapes.add(new Circle(x+489, y-89, 32, colors.get(15)));
        shapes.add(new Triangle(x+510, y-89, x+525, y-60, x+540, y-77, colors.get(15)));
        shapes.add(new Circle(x+551, y-72, 16, Color.WHITE));
        shapes.add(new Arc(x+551, y-72, 16, 0, 360, 1, Color.BLACK));
        shapes.add(new Circle(x+553, y-70, 12, Color.BLACK));
        shapes.add(new Arc(x+566, y-55, 16, 170, 160, 1, Color.BLACK));

        //Spirals 
        shapes.add(new Arc(x+359,y-24,8,90,180,1,colors.get(10)));
        shapes.add(new Arc(x+356 ,y-24,12,0,90,1,colors.get(10)));
        shapes.add(new Line(x+368,y-17,x+368,y-11,1,colors.get(10)));
        
        shapes.add(new Circle(x+296, y, 40, colors.get(1)));

        shapes.add(new Arc(x+316,y+17,8,0,180,1,colors.get(10)));
        shapes.add(new Arc(x+308,y+13,16,180,180,1,colors.get(10)));
        shapes.add(new Arc(x+308,y+10,20,90,90,1,colors.get(10)));
        shapes.add(new Line(x+319,y+10,x+335,y+10,1,colors.get(10)));

        shapes.add(new Arc(x+505, y-73, 7,0,180,1,colors.get(16)));
        shapes.add(new Arc(x+498, y-77, 14,-183,182,1,colors.get(16)));
        shapes.add(new Arc(x+498, y-80, 17,80,100,1,colors.get(16)));
        shapes.add(new Arc(x+493, y-80, 27,7,83,1,colors.get(16)));

        //Hull Trim
        shapes.add(new Line(x+196, y+44, x+320, y+44, 10, colors.get(1)));
        
        //Hull Bannister
        shapes.add(new Line(x-20, y-2, x+100, y-2, 10, colors.get(1)));
        shapes.add(new Line(x-22, y-32, x+80, y-32, 6, colors.get(1)));
        for(int i = 0; i<6; i++){ //bannister columns
            shapes.add(new Line(x-20+(16*i),y-32, x-20+(16*i) ,y,4,colors.get(1)));
        }
        shapes.add(new Line(x+77, y-32, x+77, y, 6, colors.get(1)));
        shapes.add(new Circle(x+75,y-44,20,colors.get(1)));

        //Stern Trim + Details
        shapes.add(new Line(x, y+5, x+195, y+5, 10, colors.get(1)));
        shapes.add(new Line(x+109,y+14,x+168,y+14,10,colors.get(1)));
        shapes.add(new Line(x+80, y+4, x+80, y+85, 8, colors.get(1)));
        shapes.add(new Line(x+160, y+4, x+160, y+85, 8, colors.get(1)));
        shapes.add(new Circle(x+178, y, 40, colors.get(1)));        
        shapes.add(new Curve(x+2, y+5, x+80, y+148, x+2 + (78*.6), (y+5)+(152*.3), 8 , colors.get(1)));
        
        //Spirals
        shapes.add(new Arc(x+82,y-38,8,-90,180,1,colors.get(10)));
        shapes.add(new Arc(x+80,y-38,12,90,90,1,colors.get(10)));
        shapes.add(new Line(x+80,y-32,x+80,y-26,1,colors.get(10)));
        
        shapes.add(new Arc(x+190,y+17,8,0,180,1,colors.get(10)));
        shapes.add(new Arc(x+190,y+13,16,180,180,1,colors.get(10)));
        shapes.add(new Arc(x+186,y+10,20,0,90,1,colors.get(10)));
        shapes.add(new Line(x+181,y+10,x+198,y+10,1,colors.get(10)));

        //Mast Details
                
        //Rope
        shapes.add(new Line(x+168,y+8,x+220,y,1,colors.get(7)));

        //Net
        for(int i = 0; i<4; i++){
            shapes.add(new Arc(x+115+(i*15),y+5,8,0,360,1,colors.get(10)));
            shapes.add(new Line(x+120+(i*15),y+5,x+258,y-275,1,colors.get(7)));
            for(int j = 1; j<=10; j++){
                shapes.add(new Line(x+120+(j*20*0.482143), y+5-(20*j), x+165+(j*20*0.332143), y+5-(20*j),1,colors.get(7)));
            }
        }

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
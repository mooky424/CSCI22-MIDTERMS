import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Class constructor for SceneCanvas, extends JComponent class
 * 
 * Canvas for animation in the JFrame
 * 
 * Has an ArrayList of drawing objects, which get drawn in when 
 * paintComponent method is called
 * 
 * ArrayList contains instances of GoingMerry, Cloud, and Wave classes
 * 
 * Clouds are drawn in before the ship and waves
 * 
 * Has methods which modify coordinates and rotation of ArrayList objects.
 * 
 * Also contains ArrayList that determines speed of clouds moving in animation
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

public class SceneCanvas extends JComponent {

    private double width;
    private double height;
    private ArrayList<DrawingObject> shapes;
    private ArrayList<Double> cloudVelocities;

    public SceneCanvas(int w, int h){
        width = w;
        height = h;
        setPreferredSize(new Dimension(w, h));
        shapes = new ArrayList<DrawingObject>();
        cloudVelocities = new ArrayList<Double>();
        shapes.add(new Wave(-160, height*.63, Color.decode("#2da3fb")));
        shapes.add(new GoingMerry(width*.2, height/45));
        shapes.add(new Wave(-100, height*.73, Color.decode("#31baf9")));

    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        Rectangle2D.Double background = new Rectangle2D.Double(0,0,width,height);
        g2d.setRenderingHints(rh);
        g2d.setPaint(new GradientPaint(0,0, Color.decode("#2d95f9"),0,(float) (height*.5), Color.decode("#41e5f9")));
        g2d.fill(background);

        for(int i = 3; i < shapes.size(); i++){// draw clouds before ship and waves
            shapes.get(i).draw(g2d);
        }
        for(int i = 0; i < 3; i++){ 
            shapes.get(i).draw(g2d);
        }
    }

    public ArrayList<DrawingObject> getShapes(){
        return shapes;
    }

    public void addCloud(){
        int variant = (int)(Math.random() * (3));
        double cloudHeight = 140 + Math.random() * 300; 
        shapes.add(new Cloud(width+200, cloudHeight, variant, Color.decode("#faf8f3"))); //adds new clouds to the shapes ArrayList
        cloudVelocities.add(-(Math.random() * + 5)); //cloud velocity for new clouds, cloud and velocity indexes are offset by 3 positions
    }

    public void animateGoingMerry(double xDistance, double yDistance, double degree){
        DrawingObject gm = shapes.get(1);
        gm.adjustY(yDistance);
        gm.adjustAngle(degree);
    }

    public void animateWave(double xDistance1, double yDistance1, double xDistance2, double yDistance2){
        DrawingObject w1 = shapes.get(2);
        DrawingObject w2 = shapes.get(0);
        w1.adjustX(xDistance1);
        w1.adjustY(yDistance1);
        w2.adjustX(xDistance2);
        w2.adjustY(yDistance2);
    }

    public void animateClouds(){
        for (int i = 3; i < shapes.size(); i++){
            DrawingObject cloud = shapes.get(i);
            cloud.adjustX(cloudVelocities.get(i-3));
            if(cloud.getX() < -300){ //remove cloud if past the screen, prevents lag
                shapes.remove(i);
                cloudVelocities.remove(i-3);
            }
        }
    }
}
import java.awt.*;

/**
 * DrawingObject interface used for most shapes
 * 
 * Has methods to draw, adjust coordinates, adjust angle, get coordinates, and get angle 
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

public interface DrawingObject {
    public void draw(Graphics2D g2d);
    public void adjustX(double distance);
    public void adjustY(double distance);
    public void adjustAngle(double degree);
    public double getX();
    public double getY();
    public double getAngle();
}

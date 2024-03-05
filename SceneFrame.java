import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class constructor for JFrame
 * 
 * sets up the SceneCanvas class
 * 
 * Contains timers for animation of objects in Scene Canvas
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

public class SceneFrame {

    private JFrame frame;
    private SceneCanvas sc;

    public SceneFrame(int w, int h) {
        frame = new JFrame();
        sc = new SceneCanvas(w, h);
    }

    public void setUpGUI(){
        Container cp = frame.getContentPane();

        cp.add(sc);
        
        frame.setTitle("Midterm Project - Salvador, Gabriel - 225593");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Timer clouds = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    sc.addCloud();
            }
        });

        Timer timer = new Timer(10, new ActionListener() { //need citation

            double time = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                double bobGoingMerry = (20*Math.PI/200)*Math.cos((Math.PI/200)*time++); // movement along y-axis
                double degree = -(Math.PI/20)*Math.sin((Math.PI/200)*time++); // movement along x-axis
                sc.animateGoingMerry(degree, bobGoingMerry, degree);

                double bobWave1 = (30*Math.PI/200)*Math.cos((Math.PI/200)*time++); // movement along y-axis
                double swayWave1 = (-60*Math.PI/200)*Math.sin((Math.PI/200)*time); // movement along x-axis
                double bobWave2 = (40*Math.PI/300)*Math.sin((Math.PI/300)*time++); // movement along y-axis
                double swayWave2 = (-30*Math.PI/200)*Math.sin((Math.PI/200)*time); // movement along x-axis
                sc.animateWave(swayWave1, bobWave1, swayWave2, bobWave2);

                sc.animateClouds();

                sc.repaint();
            }
        });    
        
        clouds.start();
        timer.start();
 
    }
}
/**
 * SceneStarter App which makes an app with the SceneFrame class
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

public class SceneStarter {
    public static void main (String[] args) {
        SceneFrame sf = new SceneFrame(1024, 768);
        sf.setUpGUI();
    }
}
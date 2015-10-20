import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that bounces around the screen.
 * 
 * @author Jennifer Puhalka 
 * @version 10.19.2015
 */
public class BoxBall
{
    private static final int SPEED = 3;
    
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;   // y position of ground
    private final int topPosition;      // y position of top of box
    private final int rightPosition;   // x position of right side of box
    private final int leftPosition;     // x position of left side of box
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed

    /**
     * Constructor for objects of class BoxBall
     * 
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param topPos    the position of the top
     * @param rightPos  the position of the right side
     * @param leftPos   the position of the left side
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int groundPos, 
                    int topPos, int rightPos, int leftPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        topPosition = topPos;
        rightPosition = rightPos;
        leftPosition = leftPos;
        canvas = drawingCanvas;
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Erase this ball at its current position.
     **/
     public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and re-draw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        ySpeed += SPEED;
        yPosition += ySpeed;
        xPosition +=2;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        // draw again at new position
        draw();
    }  
}
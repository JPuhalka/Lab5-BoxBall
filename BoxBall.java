import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that bounces around the screen.  The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating, and bounce off the wa
 * 
 * @author Jennifer Puhalka 
 * @version 1.1
 * @date 10.19.2015
 */
public class BoxBall
{
    private static final int ACCELERATION = 3;
   
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;   // y position of ground
    private final int topPosition;      // y position of top of box
    private final int rightPosition;    // x position of right side of box
    private final int leftPosition;     // x position of left side of box
    private Canvas canvas;
    private int ySpeed = 1;             // initial downward speed
    private int xSpeed = 1;             // initial x-direction speed

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
        ySpeed += ACCELERATION;
        xSpeed += ACCELERATION;
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) 
        {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation;
        }
        
        else if (yPosition <= (topPosition - diameter) && -ySpeed < 0)
        {
            yPosition = (int)(topPosition - diameter);
            ySpeed = ySpeed + ballDegradation;
        }
        
        else if (xPosition <= (leftPosition - diameter) && xSpeed > 0)
        {
            xPosition = (int)(leftPosition - diameter);
            xSpeed = -xSpeed + ballDegradation;
        }
        
        else if (xPosition <= (rightPosition - diameter) && xSpeed > 0)
        {
            xPosition = (int)(rightPosition - diameter);
            xSpeed = -xSpeed + ballDegradation;
        }

        // draw again at new position
        draw();
    }
    
        /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

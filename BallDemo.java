import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce()
    {
        int ground = 100;   // position of the ground line
        int top = 800;
        int right = 550;
        int left = 50;

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(left, ground, right, ground);
        // draw the top
        myCanvas.drawLine(left, top, right, top);
        //draw the left side
        myCanvas.drawLine(left, ground, left, top);
        //draw the right side
        myCanvas.drawLine(right, ground, right, top);

        // create and show the balls
        BoxBall ball = new BoxBall(50, 50, 16, Color.BLUE, ground, top, right, left, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(70, 80, 20, Color.RED, ground, top, right, left, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) 
        {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
        }
    }
}

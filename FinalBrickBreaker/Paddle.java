/**
*Patrick and Sean
*5/20/17
*This class creates a paddle for the game
*
*
*/

import javax.swing.*;
import java.awt.*;

public class Paddle extends Rectangle{
   
   public Paddle(int x, int y){
      super(x, y,GameConstants.PADDLE_WIDTH,   GameConstants.PADDLE_LENGTH);
   }
   
   
   //draws a rectangle in the bottom center of the window
   public void paint(Graphics g){
      g.fillRect(x, y, GameConstants.PADDLE_WIDTH,GameConstants.PADDLE_LENGTH);  
   }
   
   public void setLocation(int xx){
      setLocation(xx, y);
   }
    /*checks if a given ball has hit the paddle by:
    *1) checking if the two shapes intersect at all (using built-in Java methods)
    *2) creating four points for each corner of the rectangle that bounds the Ball 
    *3) Checking if any of those points are touching this Brick
    *4) If any point is colliding, calls the ball's appropriate bounce method and plays a sound effect
    *5)The bounce and sound effect are called at the same time using Thread to avoid delays
    *(Inspiration taken from Stanford CS 106 Breakout assignment)

    */ 

   public void checkHit(Ball b){
      if ((b.getBounds2D()).intersects(this)) {
         
         int ballLeft = (int) b.getX();
         int ballHeight = (int) b.getHeight();
         int ballWidth = (int) b.getWidth();
         int ballTop = (int) b.getY();
         
         Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
         Point pointLeft = new Point(ballLeft - 1, ballTop);
         Point pointTop = new Point(ballLeft, ballTop - 1);
         Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
         
         
         if (this.contains(pointRight)) {
            Thread thread1 = 
                  new Thread() {
                     public void run() {
                        b.bounceHoriz();  
                     }    
                  };
            Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.hitMarker.play();  
                     }
                  };
            thread1.start();
            thread2.start();
            
         } 
         else if (this.contains(pointLeft)) {
            Thread thread1 = 
                  new Thread() {
                     public void run() {
                        b.bounceHoriz();  
                     }    
                  };
            Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.hitMarker.play();  
                     }
                  };
            thread1.start();
            thread2.start();
            
            
         }
            
         else if (this.contains(pointTop)) {
            Thread thread1 = 
                  new Thread() {
                     public void run() {
                        b.bounceVert();  
                     }    
                  };
            Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.hitMarker.play();  
                     }
                  };
            thread1.start();
            thread2.start();
            
            
         } 
         else if (this.contains(pointBottom)) {
            Thread thread1 = 
                  new Thread() {
                     public void run() {
                        b.bounceVert();  
                     }    
                  };
            Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.hitMarker.play();  
                     }
                  };
            thread1.start();
            thread2.start();
         }
      
      
      
      }  
   }
}
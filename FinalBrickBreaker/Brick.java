//Patrick RIley
//This class represents the brick that is used to be broken by the ball
//it inherits the properites of the Rectangle class for use with collisions

import java.awt.*;
import javax.swing.*;

public class Brick extends Rectangle{
      //saves the color of the brick
   public Color color;
   public boolean isAlive;
   
   //creates a rectangle with saved color and constant size 
   public Brick(int xx, int yy,Color col){
      super(xx,yy,GameConstants.BRICK_WIDTH,GameConstants.BRICK_LENGTH);
      color = col;
      isAlive = true;
      
   }
  
    //paints the brick with a different thickness line and puts them into the rows
   public void paint(Graphics g){
      if(isAlive){
         Graphics2D g2 = (Graphics2D)g;
         g2.setStroke(new BasicStroke(2));
         g2.setColor(color);
      //creates the filled brick
         g2.fillRect(x, y, 
                  GameConstants.BRICK_WIDTH, GameConstants.BRICK_LENGTH);
         g2.setColor(Color.BLACK);
      //outlines the brick
         g2.drawRect(x, y, 
                  GameConstants.BRICK_WIDTH, GameConstants.BRICK_LENGTH);
      }
   }
   
   /*checks if a given ball has hit the brick by:
    *1) checking if the two shapes intersect at all (using built-in Java methods)
    *2) creating four points for each corner of the rectangle that bounds the Ball 
    *3) Checking if any of those points are touching this Brick
    *4) If any point is colliding, calls the ball's appropriate bounce method, speeds up the ball, and plays a sound effect
    *5)The bounce and sound effect are called at the same time using Thread to avoid delays
    *6) Sets the brick to disappear
    *(Inspiration taken from Stanford CS 106 Breakout assignment)
    */ 
   public void checkHit(Ball b){
      if(this.isAlive){
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
                        b.bounceVert(); 
                        b.speedUp(); 
                     }    
                  };
               Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.ring.play();  
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
                        b.speedUp(); 
                     
                     }    
                  };
               Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.ring.play();  
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
                        b.speedUp(); 
                     
                     }    
                  };
               Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.ring.play();  
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
                        b.speedUp(); 
                     
                     }    
                  };
               Thread thread2 = 
                  new Thread() {
                     public void run() {
                        GameConstants.ring.play();  
                     }
                  };
               thread1.start();
               thread2.start();
            }
         
            this.isAlive = false;
         }          
      
      }
      
   }
   
   
   public void reset(){
      this.isAlive = true;
   }
   
   public String toString(){
      return "Brick at: " + super.getX() + ", " + super.getY() + "; Color: " + color;
   }

}

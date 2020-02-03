/**
*Patrick and Sean
*5/20/17
*This class represents the bricks on the board
*
*
*/

import java.awt.*;
import java.util.Arrays;

public class Bricks{
   //represents the bricks on the board in a 2D array
   static Brick[][] bs = new Brick[GameConstants.NUM_ROWS][GameConstants.NUM_BRICKS];
   
   public Bricks(){
     
      Color c = Color.RED;
      //fills the 2D array with the brick and of the correct color
      for(int i = 0; i< GameConstants.NUM_ROWS; i++){
         for(int j = 0; j < (GameConstants.WINDOW_SIZE-50)/GameConstants.BRICK_WIDTH; j++){
            if(i<6)
               c = GameConstants.COLORS[i];
            else
               c = GameConstants.COLORS[i-6];
           
            Brick b = new Brick(j*GameConstants.BRICK_WIDTH+50,i*GameConstants.BRICK_LENGTH+25,c);
            bs[i][j] = b; 
         }
      }
   }
   //paints the bricks brick by brick in order
   public void paint(Graphics g){
      for(Brick[] row: bs){
         for(Brick br: row){
            if(br.isAlive)
               br.paint(g);
         }
      }            
   }
   
   public void checkBricks(Ball b){
      for(int i = 0; i < bs.length; i++){
         for(int j = 0; j<bs[i].length; j++){
            if(bs[i][j].isAlive){
               bs[i][j].checkHit(b);
            }
         }
      }
   }
      
   
   
   public boolean isEmpty(){
      for(Brick[] bri  : bs){
         for(Brick b : bri){
            if(b.isAlive)
               return false;
         }
      }
      return true;
   }
   
   
   public static void killBricks(){
      for(int i = 0; i < bs.length; i++){
         for(int j = 0; j<bs[i].length; j++){
            bs[i][j].isAlive = false;
         }
      }
   }   
   
   public static void reset(){
      for(int i = 0; i < bs.length; i++){
         for(int j = 0; j<bs[i].length; j++){
            bs[i][j].reset();
         }
      }
   } 
   
   
   public String toString(){
      for(Brick[] row: bs){
         for(Brick b: row){
            System.out.println(b);
         }
      }
      return "";
   }
   

}
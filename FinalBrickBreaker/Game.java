//patrick and sean 
//this creates the game enviornment 
//used the MouseMotionEventListener class as inspiration from the java api

import javax.swing.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;


public class Game implements MouseMotionListener{
   SetupBoard dr;
   EndGame end;
   JFrame frame;
   Timer time;
   BallTask task;
   
   public Game(){
         	
      frame = new JFrame("Breakout!");
      dr = new SetupBoard();
      end = new EndGame();
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(GameConstants.WINDOW_SIZE,GameConstants.WINDOW_SIZE);
      frame.add(dr);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.addMouseMotionListener(this);
      
      
      //Handles the Timer tasks necessary for the ball movement
      time = new Timer();
      task = new BallTask();   
      time.schedule(task, 0, GameConstants.GAME_SPEED);
      
   }
   
   public void reset(){
      
      end.invalidate();
      frame.remove(end);//removes the end screen JPanel (the one with the reset button)
      dr = new SetupBoard();//resests the SetupBoard JPanel to its original state
      Bricks.reset();//resets all bricks to be alive again
      GameConstants.isRunning = true; //resets the constant to tell if the game is still being played
      GameConstants.soundAlreadyPlayed = false; //resets the constant that checks if the end game sound is repeating
      frame.add(dr);//adds the newly reset SetupBoard JPanel to the JFrame
      frame.revalidate();
      frame.repaint();//Repaints th game
   }
   
   
   //Inspiration taken from: 
   //http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/events/MouseMotionEventDemoProject/src/events/MouseMotionEventDemo.java

   public void mouseMoved(MouseEvent e) {
      Paddle p = dr.getPaddle();
      p.setLocation(e.getX());
      dr.setPaddle(p);
      dr.invalidate();
      dr.repaint();
      
   }
    
   public void mouseDragged(MouseEvent e) {
      Paddle p = dr.getPaddle();
      p.setLocation(e.getX());
      dr.setPaddle(p);
   }
   
   
   //Uses the TimerTask class to periodically move the ball and check it against obstacles
   private class BallTask extends TimerTask {
   
       
      public void run() {
         //checks if the resest button has been pressed, and, 
         //if it has, changes again so it hasn't back and resets game
         if(GameConstants.gameReset){
            reset();
            GameConstants.gameReset = false;
         }
         Ball b = dr.getBall();
         if(GameConstants.isRunning||!dr.getBricks().isEmpty()){
            b.moveBall();  
            dr.getBricks().checkBricks(b);
            dr.getPaddle().checkHit(b);
         }
         if(!GameConstants.isRunning&&!dr.getBricks().isEmpty()){
            dr.setVisible(false);
            frame.add(end);
            if(!GameConstants.soundAlreadyPlayed){
            
               GameConstants.loss.play();
               GameConstants.soundAlreadyPlayed = true;
            }
         
         }
         else if(dr.getBricks().isEmpty()){
            dr.setVisible(false);
            frame.add(end);  
            GameConstants.isRunning = false;
            if(!GameConstants.soundAlreadyPlayed){
               GameConstants.iDubbbz.play();
               GameConstants.soundAlreadyPlayed = true;
            }
         }
         
         dr.invalidate();
         dr.repaint();
      }
   }
   



}
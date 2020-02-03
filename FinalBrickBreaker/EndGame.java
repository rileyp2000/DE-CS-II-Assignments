//this class displays the screen after the game ends

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class EndGame extends SetupBoard{
   
   public JButton reset; 
   
//inspired by the code from the netbeans editor
   public EndGame(){
      reset = new JButton("Reset");
      reset.setAlignmentY(0.0F);
   
      GroupLayout layout = new GroupLayout(this);
      setLayout(layout);
      layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(reset, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
         );
      layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(284, Short.MAX_VALUE)
                .addComponent(reset, GroupLayout.PREFERRED_SIZE, 70,GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
         );
      reset.addActionListener(new ResetButtonListener());
      add(reset);
   }   

   
   
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);  
      paintStuff(g);
      repaint();
      invalidate();
   }

   public void paintStuff(Graphics g){
      if(!GameConstants.isRunning)
         loseGame(g);
      if(b.isEmpty())
         winGame(g);
        
   }
   
   
   
   private class ResetButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      { 
         resetGame();
         System.out.print(b.isEmpty());
      }
   } 
   
   public void resetGame(){
      GameConstants.gameReset = true;
   }

   
   public void loseGame(Graphics g){
      if(!GameConstants.isRunning){
         g.setColor(new Color(195, 195, 195));   
         g.fillRect(0,0,GameConstants.WINDOW_SIZE,GameConstants.WINDOW_SIZE);
         g.setColor(Color.BLACK);
         g.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
         g.drawString(GameConstants.lost, GameConstants.WINDOW_SIZE/7, GameConstants.WINDOW_SIZE/4);
      }
   }
   
   public void winGame(Graphics g){
      if(!GameConstants.isRunning){
         g.setColor(Color.CYAN);
         g.fillRect(0,0,GameConstants.WINDOW_SIZE,GameConstants.WINDOW_SIZE);
         g.setColor(Color.BLACK);
         g.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
         g.drawString(GameConstants.won, GameConstants.WINDOW_SIZE/7, GameConstants.WINDOW_SIZE/4);
      }
   }


}
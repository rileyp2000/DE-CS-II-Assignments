/**
*Patrick and Sean
*5/20/17
*This class defines the velocity of an object
*
*/

public class Velocity{
   private double vx, vy;
   
   public Velocity(int x, int y){
      vx = x;
      vy = y;
   }
   public double getVX(){
      return vx;
   }
      
   public double getVY(){
      return vy;
   }
   public void setVX(double v){
      vx =v;
   }
   public void setVY(double v){
      vy =v;
   }
   public void setVelocity(double x, double y){
      vx = x;
      vy = y;
   }

}
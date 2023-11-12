import java.awt.Graphics2D;
import java.awt.Rectangle;

//Jake Lulla
//Program description:
//Jan 6, 2022

public abstract class Sprite
{
   private double x, y, dx, dy;
   private int w, h;
   
   public Sprite(double x, double y, int w, int h, double dx, double dy) {
      this.x = x;
      this.y = y;
      this.dx = dx;
      this.dy = dy;
      this.w = w;
      this.h = h;
   }
   
   public Sprite() {
      this.x = 0;
      this.y = 0;
      this.dx = 10;
      this.dy = 10;
      this.w = 0;
      this.h = 0;
   }
   
   public void update() {
      System.out.println("Updating the sprite");
   }
   
   public Rectangle getBounds() {
      return new Rectangle((int)x, (int)y, w, h);
   }
   
   public void draw(Graphics2D g2)
   {
      g2.draw(getBounds());      
   }
   
   public double getX()
   {
      return x;
   }
   
   public void setX(double x)
   {
      this.x = x;
   }
   
   public double getY()
   {
      return y;
   }
   
   public void setY(double y)
   {
      this.y = y;
   }
   
   public double getDx()
   {
      return dx;
   }
   
   public void setDx(double dx)
   {
      this.dx = dx;
   }
   
   public double getDy()
   {
      return dy;
   }
   
   public void setDy(double dy)
   {
      this.dy = dy;
   }
   
   public int getW()
   {
      return w;
   }
   
   public void setW(int w)
   {
      this.w = w;
   }
   
   public int getH()
   {
      return h;
   }
   
   public void setH(int h)
   {
      this.h = h;
   }
   public boolean collision(Sprite other) {
      return other.getBounds().intersects(getBounds());
//      return other.getBounds().getX() < getBounds().getX() + getBounds().getWidth()
//            && other.getBounds().getY() < getBounds().getY() + getBounds().getHeight()
//            && other.getBounds().getX() + other.getBounds().getWidth() > getBounds().getX();
   }
   
   public abstract void reset();
   
   @Override
   public String toString()
   {
      return "Sprite [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", w=" + w + ", h=" + h + "]";
   }
   

}

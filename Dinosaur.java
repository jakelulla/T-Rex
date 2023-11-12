import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Dinosaur extends Sprite{	
	private double imageCounter;
	private double jumpSpeed, gravity;
	private boolean jumping, falling, ducking;
	private Image[] runImages, duckImages;
	
	public Dinosaur()
	{
	   super(30, 100, 50, 50, 0, 0);
		jumpSpeed = -1.6;
		gravity = 0.015;
		imageCounter = 0;
		runImages = new Image[2];
	   duckImages = new Image[2];
		runImages[0] = new ImageIcon(this .getClass().getResource("dino1.png")).getImage();
		runImages[1] = new ImageIcon(this.getClass().getResource("dino2.png")).getImage();
	   duckImages[0] = new ImageIcon(this .getClass().getResource("dino_duck1.png")).getImage();
	   duckImages[1] = new ImageIcon(this.getClass().getResource("dino_duck2.png")).getImage();
	}
	
	public Dinosaur(double x, double y, int w, int h, double jumpSpeed, double gravity) {
		super(x, y, w, h, 0, 0);
		this.jumpSpeed = jumpSpeed;
		this.gravity = gravity;
	}
	
	public void update()
	{
	   if(jumping) {
	      setDy(jumpSpeed);
	      jumping = false;
	      falling = true;
	   }
	   else if(falling && !ducking) {
	      setDy(getDy()+gravity);
	   }   
	   if(ducking) {
	      setH(30);
	      setY(120);
	   }
	   else if(!falling){
	      setH(50);
	      setY(100);
	   }	   
	   if(!ducking && getY() + getDy() > 100) {
	      setY(100);
	      setDy(0);
	      falling = false;
	   }
	   imageCounter += 0.025;
	   setY(getY() + getDy());
	}
	
	public void draw(Graphics2D g2)
	{
		g2.draw(getBounds());
		if(!ducking && !falling)
		   g2.drawImage(runImages[(int)imageCounter%2], (int)getX(), (int)getY(), getW(), getH(), null);
		else if(ducking)
		   g2.drawImage(duckImages[(int)imageCounter%2], (int)getX(), (int)getY(), getW(), getH(), null);
		else
		   g2.drawImage(runImages[0], (int)getX(), (int)getY(), getW(), getH(), null);
	}
	
	public void reset()
	{
      setX(30);
      setY(100);
      setW(50);
      setH(50);
      setDy(0);
	   jumping = false;
	   falling = false;
	   ducking = false;
	}

	public double getJumpSpeed() {
		return jumpSpeed;
	}

	public void setJumpSpeed(double jumpSpeed) {
		this.jumpSpeed = jumpSpeed;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public boolean isFalling()
   {
      return falling;
   }

   public void setFalling(boolean falling)
   {
      this.falling = falling;
   }

   public boolean isJumping()
   {
      return jumping;
   }

   public void setJumping(boolean jumping)
   {
      this.jumping = jumping;
   }
   
   public void jump()
   {
      if(!jumping && !falling && !ducking)
         jumping = true;
   }

   public boolean isDucking()
   {
      return ducking;
   }

   public void setDucking(boolean ducking)
   {
      this.ducking = ducking;
   }
   
   public void duck()
   {
      if(getDy() == 0 && !jumping && !falling)
         ducking = true;
//      System.out.println("Trying to duck! dy = " + dy + " jumping = " + jumping
//            + " falling = " + falling + " ducking = " + ducking);
   } 
   @Override
   public String toString()
   {
      return super.toString() + " Dinosaur [jumpSpeed=" + jumpSpeed + ", gravity=" + gravity
            + "]";
   }

 
	
}

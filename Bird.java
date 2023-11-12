import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;


//Jake Lulla
//Program description:
//Jan 6, 2022

public class Bird extends Sprite
{
   private Image[] birdImages;
   private Image currentImage;   
   public Bird()
   {
      super(920, 85, 35, 20, -1, 0);
      birdImages = new Image[1];
      birdImages[0] = new ImageIcon(this .getClass().getResource("bird.png")).getImage();      
   }
   
   public void update()
   {
      setX((getX() + getDx()));
      if(getX() < -getW()) {
         setX(620);
      }
   }
   public void draw(Graphics2D g2) {
      g2.draw(getBounds());
      g2.drawImage(birdImages[0], (int)getX(), (int)getY(), getW(), getH(), null);
   }
   
   @Override
   public void reset()
   {
      setX(920);
   }
        
   public Image[] getBirdImages()
   {
      return birdImages;
   }
   
   public void setBirdImages(Image[] cactusImages)
   {
      this.birdImages = cactusImages;
   }
   
   public Image getCurrentImage()
   {
      return currentImage;
   }
   
   public void setCurrentImage(Image currentImage)
   {
      this.currentImage = currentImage;
   }

   @Override
   public String toString()
   {
      return super.toString() + "Bird [birdImages=" + Arrays.toString(birdImages) + ", currentImage=" + currentImage + "]";
   }  


 
}
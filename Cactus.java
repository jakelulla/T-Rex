import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;


//Jake Lulla
//Program description:
//Jan 6, 2022

public class Cactus extends Sprite
{
   private Image[] cactusImages;
   private Image currentImage;  
   public Cactus()
   {
      super(620, 115, 20, 35, -1, 0);
      cactusImages = new Image[1];
      cactusImages[0] = new ImageIcon(this .getClass().getResource("cactus.png")).getImage(); 
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
      g2.drawImage(cactusImages[0], (int)getX(), (int)getY(), getW(), getH(), null);
   }
   
   @Override
   public void reset()
   {
      setX(620);
   }
        
   public Image[] getCactusImages()
   {
      return cactusImages;
   }
   
   public void setCactusImages(Image[] cactusImages)
   {
      this.cactusImages = cactusImages;
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
      return super.toString() + "Cactus [cactusImages=" + Arrays.toString(cactusImages) + ", currentImage=" + currentImage + "]";
   }  



}
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DinosaurGame extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 600;
   public static final int PREF_H = 200;

   private ArrayList<Sprite> sprites;
   private int score;
   private boolean playing;
   private Timer timer;

   public DinosaurGame()
   {
      this.addKeyListener(this);
      this.setFocusable(true);
      
      sprites = new ArrayList <Sprite>();
      sprites.add(new Dinosaur());
      sprites.add(new Cactus());
      sprites.add(new Bird());
      
      score = 0;

      timer = new Timer(2, new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            update();
            repaint();
         }
      });
      timer.start();
   }

   public void update()
   {
      if (playing)
      {
         score += 1;
         for(Sprite s : sprites) {
            s.update();
         }
      }
      for(int i = 1; i < sprites.size(); i++) {
         if(sprites.get(0).collision(sprites.get(i))) {
            playing = false;
         }
      }
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setFont(new Font("Cooper Black", Font.PLAIN, 25));
      g2.drawString(score + "", 500, 50);
      for(Sprite s : sprites) {
         s.draw(g2);
      }
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Dino!");
      frame.getContentPane().add(new DinosaurGame());
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            createAndShowGUI();
         }

      });
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      Dinosaur dino = (Dinosaur) sprites.get(0);
      if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) && !dino.isFalling() && !dino.isDucking())
      {
         dino.setJumping(true);
         playing = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN && !dino.isJumping() && !dino.isFalling() && playing)
         dino.duck();
      if (e.getKeyCode() == 'R')
      {
         for(Sprite s : sprites) {
            s.reset();
         }
         score = 0;
      }
   }

   public void keyReleased(KeyEvent e)
   {
      Dinosaur dino = (Dinosaur) sprites.get(0);
      if (e.getKeyCode() == KeyEvent.VK_DOWN)
         dino.setDucking(false);
   }

   @Override
   public void keyTyped(KeyEvent e)
   {
   }
}

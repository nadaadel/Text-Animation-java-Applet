import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;


public class Arrows extends Applet implements Runnable {
      String s = "Hello Java";
      Thread t;
      boolean state = false;
      int x = 100;
      int y =100;
 

      public void init(){
       t = new Thread(this);
       t.start();

   addKeyListener(new KeyAdapter() {
   public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
        if(x==0){
               x=0;
			}else{
              x--;
			}
			repaint();
		}
   

    if (key == KeyEvent.VK_RIGHT) {
       if(x == getWidth())
			{
                x = getWidth();
			}
			else
			{
				x++ ;
			}
      
  }
    if (key == KeyEvent.VK_UP) {
       if(y==0)
               {
                	y=0;
               }else{
                	y-- ;
               }
    }

    if (key == KeyEvent.VK_DOWN) {
         if(y == getHeight())
            {
            	y = getHeight();
            }else{
            	y++;
            }
    }
   }
      // public void keyTyped(KeyEvent e) {
      // }

      // public void keyPressed(KeyEvent e) {
      // }
  });
}
      public void run(){
      	while(true){
      		repaint();

      		try{
      			Thread.sleep(300);
      		}
      		catch(Exception e ){
      			e.printStackTrace();
      			System.out.println("Exception");
      		}
      	}        

      }

	      public void paint(Graphics g ){
	        Font f = new Font("Impact" , Font.BOLD , 66);
	        g.setColor(Color.RED);  
	        g.drawString(s, x, y);
	        
	        }

}

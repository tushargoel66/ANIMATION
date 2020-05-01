package animation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable {
    
    Window window;
    int w=640;
    int h=480;
    public JFrame j;
    Thread t;
    JPanel jp;
    boolean state=false;
    Random r=new Random();
    Player p;
    Game(){
        j=new JFrame("Welcome!!!");
        j.setSize(640,480);
        j.setResizable(false);
        j.setLayout(null);
        jp=new JPanel();
        jp.setSize(new Dimension(640,480));
        jp.setBackground(Color.black);
        window=new Window(j);
        j.add(jp);
        t=new Thread(this);
        t.start(); 
        state=true;
        
    }
    
    public void run(){
        int c=0;
        try{
            j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
            j.setVisible(true);
            while(state){
                Graphics g=j.getGraphics();
                new Player().render(g);
                Thread.sleep(100);
                c++;
                if(c==300){
                    j.repaint();
                    c=0;
                }
                System.out.println(c);
            }
            
        }
        catch(Exception e){}
    }
     
   
    public void stop(){
        try{
            t.join();
            System.out.println("Game Claosed!!!");
            state=false;
        }
        catch(Exception e){}
    }
    
    public void render(){
        
        //p.tick();
    }
    
    public static void main(String[] args) {
        new Game();
        
    }

   
}

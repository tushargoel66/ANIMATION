package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player{

    Random r=new Random();
    int velx=5,vely=5;
    int x=r.nextInt(640),y=r.nextInt(480);
    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, velx, velx);
        
    }

    public void tick() {
        x+=velx;
        y+=vely;
    }
    
    
}

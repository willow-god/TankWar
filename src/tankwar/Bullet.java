package tankwar;

import java.awt.*;

public class Bullet extends GameObject{

    private int width = 10 ;//长宽
    private int height = 10 ;
    private int speed = 7 ;//速度

    Direction direction;//方向
    public Bullet(String img, int x, int y, Direction direction,GamePanel gamePanel) {
        super(img,x,y,gamePanel);
        this.direction=direction;
    }

    public void go() {
        switch (direction) {
            case UP:    upward();   break;
            case DOWN:  downward(); break;
            case LEFT:  leftward(); break;
            case RIGHT: rightward();break;
        }
    }

    public void leftward()  {   x-=speed;   }
    public void rightward() {   x+=speed;   }
    public void upward()    {   y-=speed;   }
    public void downward()  {   y+=speed;   }
    public void paintSelf(Graphics g)   { g.drawImage(img,x,y,null); go(); }
    public Rectangle getRec()   {   return new Rectangle(x,y,width,height); }
}

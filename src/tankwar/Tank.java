package tankwar;

import java.awt.*;

public class Tank extends GameObject{

    private String upImage;
    private String downImage;
    private String leftImage;
    private String rightImage;

    int width = 40;
    int height = 50;

    Direction direction = Direction.UP;//初始方向上

    private int speed = 3;


    //方向操作四个方位
    public void leftward(){
        direction = Direction.LEFT;
        setImg(leftImage);
        this.x -= speed;
    }

    public void rightward(){
        direction = Direction.RIGHT;
        setImg(rightImage);
        this.x += speed;
    }

    public void upward(){
        direction = Direction.UP;
        setImg(upImage);
        this.y -= speed;
    }

    public void downward(){
        direction = Direction.DOWN;
        setImg(downImage);
        this.y += speed;
    }

    @Override
    public void paintSelf(Graphics g){g.drawImage(img,x,y,null);};

    @Override
    public Rectangle getRec() {return new Rectangle(x,y,width,height);}

    public Tank(String img, int x, int y, String upImage, String downImage, String leftImage, String rightImage, GamePanel gamePanel) {
        super(img,x,y,gamePanel);
        this.upImage = upImage;
        this.downImage = downImage;
        this.leftImage = leftImage;
        this.rightImage = rightImage;
    }

}

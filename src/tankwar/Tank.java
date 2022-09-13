package tankwar;

import java.awt.*;

public class Tank extends GameObject{

    private String upImage;
    private String downImage;
    private String leftImage;
    private String rightImage;

    int width = 40;
    int height = 50;

    @Override
    public void paintSelf(Graphics g){};

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

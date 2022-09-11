package tankwar;

import java.awt.*;

public abstract class GameObject {
    Image img;//游戏元素图片
    int x;//横坐标
    int y;//纵坐标
    int width;//玩家宽
    int height;//玩家高
    int speed;//玩家移动速度
    Direction direction;//移动方向
    GamePanel gamePanel;//引入主界面

    public GameObject() {}
    public GameObject(String img, int x, int y, GamePanel gamePanel) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
    }
    public Image getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public GamePanel getGamePanel() {
        return gamePanel;
    }
    public void setGamePanel(GamePanel gamepanel) {
        this.gamePanel = gamePanel;
    }
    public abstract void paintSelf(Graphics g);//继承元素绘制自己的方法
    public abstract Rectangle getRec(); //获取当前游戏元素的矩形,碰撞检测
}

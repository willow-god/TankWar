package tankwar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JFrame {

    Image offScreenImage = null;//定义双缓存图片
    //游戏状态 0未开始 1运行中 2暂停 3失败 4成功
    public int state = 0;
    private boolean start = false;//游戏是否开始
    int a = 1;//临时变量

    public int count = 0;//重绘次数
    int width = 800;
    int height = 610;

    public List<Bullet> bulletList = new ArrayList<>();
    public List<Tank> tankList = new ArrayList<>();
    public List<Bot> botList = new ArrayList<>();

    Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
    //指针图片
    //private  Image select = Toolkit.getDefaultToolkit().getImage("images//selecttank.gif");
    //指针初始纵坐标
    private int y = 150;

    //玩家
    private PlayerOne playerOne = new PlayerOne(
            "images/player1/p1tankU.gif",
            125,
            510,
            "images/player1/p1tankU.gif",
            "images/player1/p1tankD.gif",
            "images/player1/p1tankL.gif",
            "images/player1/p1tankR.gif",
            this);

    //窗口启动
    public void launch(){
        setTitle("坦克大战");
        setSize(width, height);
        setLocationRelativeTo(null);//添加关闭按钮
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//不能调整大小
        setResizable(false);//窗口可见
        setVisible(true);//添加键盘事件
        this.addKeyListener(new GamePanel.KeyMonitor());

        while(true){
            if (count%100==1) {
                Random r = new Random();
                int rnum = r.nextInt(800);
                botList.add(new Bot("images/enemy/enemy1U.gif", rnum, 110,
                        "images/enemy/enemy1U.gif","images/enemy/enemy1D.gif",
                        "images/enemy/enemy1L.gif","images/enemy/enemy1R.gif", this));
                //System.out.println("bot: " + botList.size());
            }
            repaint();
            try {
                Thread.sleep(25);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public  void paint(Graphics g) {
        //创建和容器一样大小的图片
        if (offScreenImage == null) {
            offScreenImage = this.createImage(width,height);
        }
        //获得此图片相应的画布
        Graphics gImage = offScreenImage.getGraphics();
        //设置背景颜色
        gImage.setColor(Color.gray);
        //填充整个屏幕
        gImage.fillRect(0,0,width,height);
        //改变画笔颜色
        gImage.setColor(Color.blue);
        //改变文字大小和样式
        gImage.setFont(new Font("仿宋",Font.BOLD,50));
        if (state == 0) {
            gImage.drawString("选择游戏模式",220,100);
            gImage.drawString("单人模式",220,200);
            gImage.drawString("双人模式",220,300);
            gImage.drawString("按1，2选择游戏，按回车开始游戏",0,400);
            gImage.drawImage(select,160,y,null);
        }
        else if (state ==1||state == 2) {
            gImage.drawString("游戏开始",220,300);
            if(state == 1){
                gImage.drawString("单人模式",220,200);
            }
            else{
                gImage.drawString("双人模式",220,200);
            }
            //重绘游戏元素
            playerOne.paintSelf(gImage);
            for (Bullet bullet: bulletList){
                bullet.paintSelf(gImage);
            }

            for (Bot bot:botList) {
                bot.paintSelf(gImage);
            }
            count++;
        }
        //将缓冲区绘制好的图形绘制到容器中
        g.drawImage(offScreenImage,0,0,null);
    }


    private class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_1:
                    if (!start) {
                        y = 150;
                        a = 1;
                    }
                    //System.out.println(state);//调试使用
                    break;
                case KeyEvent.VK_2:
                    if (!start) {
                        y=250;
                        a=2;
                    }
                    //System.out.println(state);//调试使用
                    break;
                case KeyEvent.VK_ENTER:
                    tankList.add(playerOne);
                    state = a;
                    start = true;
                    //System.out.println("state:"+""+state);//调试使用
                    break;
                default:
                    playerOne.keyPressed(e);
                    break;
            }
        }
    }

    //@Override//为什么不能重写啊挖草
    public void keyReleased(KeyEvent e) {
        playerOne.keyReleased(e);
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}

package tankwar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JFrame {

    //游戏状态 0未开始 1运行中 2暂停 3失败 4成功
    public int state = 0;
    private boolean start = false;//游戏是否开始
    int a = 0;//临时变量

    int width = 800;
    int height = 610;

    //指针图片
    private  Image select = Toolkit.getDefaultToolkit().getImage("images//selecttank.gif");
    //指针初始纵坐标
    private int y = 150;

    //窗口启动
    public void launch(){
        setTitle("坦克大战");
        setSize(width, height);
        setLocationRelativeTo(null);
        //添加关闭按钮
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //不能调整大小
        setResizable(false);
        //窗口可见
        setVisible(true);
        //添加键盘事件
        this.addKeyListener(new GamePanel.KeyMonitor());

        while(true){
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
        //设置背景颜色
        g.setColor(Color.gray);
        //填充整个屏幕
        g.fillRect(0,0,width,height);
        //改变画笔颜色
        g.setColor(Color.blue);
        //改变文字大小和样式
        g.setFont(new Font("仿宋",Font.BOLD,50));
        if (state == 0) {
            g.drawString("选择游戏模式",220,100);
            g.drawString("单人模式",220,200);
            g.drawString("双人模式",220,300);
            g.drawString("按1，2选择游戏，按回车开始游戏",0,400);
            g.drawImage(select,160,y,null);
        }
        else if (state ==1||state == 2) {
            g.drawString("游戏开始",220,300);
            if(state == 1){
                g.drawString("单人模式",220,200);
            }
            else{
                g.drawString("双人模式",220,200);
            }
        }
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
                    System.out.println(state);
                    break;
                case KeyEvent.VK_2:
                    if (!start) {
                        y=250;
                        a=2;
                    }
                    System.out.println(state);
                    break;
                case KeyEvent.VK_ENTER:
                    state = a;
                    start = true;
                    System.out.println("state:"+""+state);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}

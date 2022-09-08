package tankwar;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {
    int width = 800;
    int height = 610;

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
        g.drawString("选择游戏模式",220,100);
        g.drawString("单人模式",220,200);
        g.drawString("双人模式",220,300);
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}

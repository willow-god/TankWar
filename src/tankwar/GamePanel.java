package tankwar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JFrame {

    //双缓存图片
    Image offScreenImage = null;
    //游戏状态 0未开始 1运行中 2暂停 3失败 4成功
    int state = 0;
    int a = 0;

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
        //添加键盘事件
        this.addKeyListener(new GamePanel.KeyMonitor());
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

    private class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            System.out.println(key);
            System.out.println(e.getKeyChar());
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}

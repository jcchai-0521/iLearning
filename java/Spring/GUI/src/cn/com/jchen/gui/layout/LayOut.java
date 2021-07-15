package cn.com.jchen.gui.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayOut
{
    public static void main(String[] args)
    {
        // test1();

        test2();



    }

    private static void test2()
    {
        Frame frame = new Frame("布局测试2");
        // 自动填充布局
        frame.setVisible(true);
        frame.setBounds(200, 200, 500, 500);
        frame.setBackground(new Color(42, 42, 231));

        // 设置上下两个面板
        frame.setLayout(new GridLayout(2, 1));

        Panel topPanel = new Panel();
        topPanel.setBackground(new Color(1,2,3));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(new Button("左"), BorderLayout.EAST);
        Panel topCenterPanel = new Panel(new GridLayout(2,1));
        topCenterPanel.add(new Button("嘿嘿"));
        topCenterPanel.add(new Button("哈哈"));
        topPanel.add(topCenterPanel, BorderLayout.CENTER);
        topPanel.add(new Button("右"), BorderLayout.WEST);

        Panel buttomPanel = new Panel();
        buttomPanel.setBackground(new Color(205, 70, 205));
        buttomPanel.setLayout(new BorderLayout());
        buttomPanel.add(new Button("左"), BorderLayout.EAST);
        Panel buttomCenterPanel = new Panel(new GridLayout(2,2));
        for (int i = 0; i < 4; i++)
        {
            buttomCenterPanel.add(new Button("咯咯咯" + i));
        }

        buttomPanel.add(buttomCenterPanel, BorderLayout.CENTER);
        buttomPanel.add(new Button("左"), BorderLayout.WEST);

        frame.add(topPanel);
        frame.add(buttomPanel);

        closeFrame(frame);


    }

    /**
     * 窗口关闭处理
     * @param frame 主窗口
     */
    private static void closeFrame(Frame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    private static void test1()
    {
        Frame frame = new Frame("布局测试");

        // 使用左中右布局方式
        frame.setLayout(new BorderLayout());

        // 1.左边布局设置
        Panel eastPanel = new Panel(new BorderLayout(1, 2));
        eastPanel.add(new Button("上"));
        eastPanel.add(new Button("下"));
        frame.add(eastPanel, BorderLayout.EAST);

        // 2.中间布局
        Panel centerPanel = new Panel(new BorderLayout(1, 2));
        // 2.1 上布局
        Panel center_topPanel = new Panel(new BorderLayout(1, 2));
        center_topPanel.add(new Button("上"));
        center_topPanel.add(new Button("下"));
        centerPanel.setVisible(true);
        centerPanel.add(center_topPanel);
        // 2.2 下布局
        Panel center_bottomPanel = new Panel(new BorderLayout(2, 2));
        center_topPanel.add(new Button("左上"));
        center_topPanel.add(new Button("右上"));
        center_topPanel.add(new Button("左下"));
        center_topPanel.add(new Button("右下"));
        centerPanel.add(center_bottomPanel);
        frame.add(centerPanel, BorderLayout.CENTER);

        // 右边布局
        Panel westPanel = new Panel(new BorderLayout(1, 2));
        westPanel.add(new Button("上"));
        westPanel.add(new Button("下"));
        frame.add(westPanel, BorderLayout.WEST);

        // 自动填充布局
        frame.setVisible(true);
        frame.setBounds(200, 200, 500, 500);
        frame.setBackground(new Color(42, 42, 231));
    }
}

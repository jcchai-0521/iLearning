package cn.com.jchen.gui.paint;

import cn.com.jchen.gui.base.BaseFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPaint extends BaseFrame
{
    /**
     * 鼠标点击的位置集合
     */
    private List<Point> mouseApoint = new ArrayList<>();

    public MyPaint(String title)
    {
        // 设置窗口标题
        super(title);

        this.addMouseListener(new MyMouseListener());
    }

    @Override
    public void loadFrame()
    {
        super.loadFrame();

        setBounds(300, 300, 600, 500);
    }

    /**
     * 重写画笔，在窗口调用repaint的时候回进行调用
     * @param g
     */
    @Override
    public void paint(Graphics g)
    {
        Iterator<Point> iterator = mouseApoint.iterator();
        while (iterator.hasNext())
        {
            Point next = iterator.next();
            g.setColor(Color.BLACK);
            g.fillOval(next.x, next.y, 10, 10);
        }
    }

    public void addPoint(Point point)
    {
        mouseApoint.add(point);
    }

    class MyMouseListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            System.out.println("点了一下");
            // 获取当前的坐标
            MyPaint myPaint = (cn.com.jchen.gui.paint.MyPaint) e.getSource();

            // 添加的鼠标点击集合中
            myPaint.addPoint(new Point(e.getX(), e.getY()));

            // 重新对页面进行渲染处理
            myPaint.repaint();
        }
    }


}

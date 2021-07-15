package cn.com.jchen.gui.base;

import cn.com.jchen.gui.common.CommonActionListener;

import java.awt.*;

public class BaseFrame extends Frame
{
    public BaseFrame()
    {

    }

    public BaseFrame(String title)
    {
        super(title);
    }

    public void loadFrame()
    {
        // 设置位置
        //        setLocation(200,200);

        // 设置大小
        //        setSize(200, 20);

        // 设置可见性
        setVisible(true);

        // 设置背景色
        //        setBackground(Color.blue);

        // 设置布局方式，使用默认布局，流式布局
        setLayout(new FlowLayout());

        // 设置自动填充
        pack();

        CommonActionListener.addClosingListener(this);
    }
}

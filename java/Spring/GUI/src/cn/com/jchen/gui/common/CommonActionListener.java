package cn.com.jchen.gui.common;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CommonActionListener
{
    /**
     * 设置窗口关闭监听处理
     * @param frame
     */
    public static void addClosingListener(Frame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            /**
             * 关闭触发
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }

            /**
             * 激活触发
             * @param e
             */
            @Override
            public void windowActivated(WindowEvent e)
            {
                super.windowActivated(e);
            }
        });
    }
}

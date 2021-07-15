package cn.com.jchen.gui.keyBoard;

import cn.com.jchen.gui.base.BaseFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 键盘事件监听
 */
public class KeyBoard extends BaseFrame
{
    public KeyBoard()
    {
        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                System.out.println("当前按下的键：" + keyCode);
            }
        });
    }


    @Override
    public void loadFrame()
    {
        super.loadFrame();
        setBounds(200, 300, 4000, 500);
    }


}

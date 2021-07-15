package cn.com.jchen.gui;

import cn.com.jchen.gui.calc.Calculator;
import cn.com.jchen.gui.keyBoard.KeyBoard;
import cn.com.jchen.gui.paint.MyPaint;

public class GUIApplication
{
    public static void main(String[] args)
    {
        GUIApplication guiApplication = new GUIApplication();
//        guiApplication.testPaint();

        guiApplication.testKeyPress();
    }

    private void testKeyPress()
    {
        KeyBoard keyBoard = new KeyBoard();
        keyBoard.loadFrame();
    }

    /**
     * 测试画笔，绑定鼠标的监听事件
     */
    private void testPaint()
    {
        MyPaint myPaint = new MyPaint("我的画图工具");
        myPaint.loadFrame();
    }


    public void testCalc()
    {
        new Calculator().loadFrame();
    }
}

package cn.com.jchen.gui.calc;

import cn.com.jchen.gui.base.BaseFrame;
import cn.com.jchen.gui.utils.CalcUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends BaseFrame
{
    private TextField oneParam;
    private TextField otherParam;
    private TextField result;

    public Calculator()
    {
        // 三个文本框、一个label，一个按钮
        oneParam = new TextField(10);
        otherParam = new TextField(10);
        result = new TextField(20);

        // 计算按钮
        Button calcBtn = new Button("=");
        calcBtn.addActionListener(new calcBtnActionListener());

        add(oneParam);
        add(new Label("+"));
        add(otherParam);
        add(calcBtn);
        add(result);


    }

    class calcBtnActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // 1.获取两个输入框的值
            String oneVal = oneParam.getText();
            String otherVal = otherParam.getText();

            // 2.计算两个输入框的值并将结果设置到第三个输
            result.setText(String.valueOf(CalcUtils.add(oneVal, otherVal)));

            // 3.设置前两个输入框的值为空
            oneParam.setText("");
            otherParam.setText("");
        }
    }

}

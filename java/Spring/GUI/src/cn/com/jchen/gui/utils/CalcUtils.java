package cn.com.jchen.gui.utils;

import java.math.BigDecimal;

/**
 * 计算工具类
 */
public class CalcUtils
{
    /**
     * 两个数进行相加处理
     * @param one 加数
     * @param other 加数
     * @return 和
     */
    public static double add(String one, String other)
    {
        BigDecimal bigDecimal = new BigDecimal(one);
        return bigDecimal.add(new BigDecimal(other)).doubleValue();
    }
}

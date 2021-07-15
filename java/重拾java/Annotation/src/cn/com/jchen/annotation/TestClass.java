package cn.com.jchen.annotation;

import java.lang.annotation.ElementType;

/**
 * 那些对象可以获取class对象
 */
public class TestClass
{
    public static void main(String[] args)
    {
        // 类获取class
        Class<Object> objectClass = Object.class;
        // 接口
        Class<Runnable> runnableClass = Runnable.class;
        // 数组
        Class<String[]> aClass = String[].class;
        // 枚举
        Class<ElementType> elementTypeClass = ElementType.class;
        // 修饰符
        Class<Void> voidClass = void.class;
        // 注解
        Class<Override> overrideClass = Override.class;
        // CLass类
        Class<Class> classClass = Class.class;
    }
}

package cn.com.jchen.annotation;

public class Test06
{
    static {
        System.out.println("main初始化");
    }

    public static void main(String[] args)
    {
        // 初始化子类时，父类也跟着初始化

        // 反射加载子类时，父类也会初始化

        // 通过子类调用父类的静态变量不会导致子类的初始化

        // 调用final变量不会导致类的初始化
    }
}

class Father
{
    public static int father = 10;
    static {
        System.out.println("父类初始化");
    }
}

class Son extends Father
{
    static {
        System.out.println("子类初始化");
    }

    public static int son = 10;
    public static final String AGE = "heiheihei";
}

package cn.com.jchen.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Test2
public class MyAnnotation
{

}

// 生效目标，Type表示类、接口、枚举等
@Target(ElementType.TYPE)
// runtime声明周期生效
@Retention(RetentionPolicy.RUNTIME)
// 生成到Javadoc中
@Documented
// 可以让子类继承
@Inherited
@interface Test2
{
    String value() default "呵呵";
}
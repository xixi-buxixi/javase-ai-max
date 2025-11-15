package annotation;

import org.junit.Test;

public class annotationTest {
    @Test
    public void test1(){
        // 创建对象
        Class c1=demo1.class;
        //判断类上是否存在A
        boolean hasAnnotation = c1.isAnnotationPresent(A.class);
        if(hasAnnotation){
            // 获取A
            A annotation = (A)c1.getAnnotation(A.class);
            // 获取注解的属性值
            String name = annotation.name();
            int age = annotation.age();
            System.out.println(name);
            System.out.println(age);
        }
    }
}

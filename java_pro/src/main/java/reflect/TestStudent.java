package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestStudent {
    @Test
    public  void test1() throws Exception {
        Class c1=student.class;
        System.out.println(c1);
        Class c2=Class.forName("reflect.student");
        System.out.println(c2);

        Field[] fields=c1.getFields();
        Field f1=c1.getDeclaredField("name");
        Field f2=c2.getDeclaredField("sex");
        f1.setAccessible( true);
        f2.setAccessible( true);
        student s12=new student("李四",20);
        f2.set(s12,"男");
        System.out.println(f1);
        for (Field field:fields){
            System.out.println(field);
        }
        Constructor conn=c1.getConstructor(String.class,int.class,String.class);
        conn.setAccessible( true);
        student s1=(student) conn.newInstance("张三",20,"男");
        System.out.println(s1);
        Method m1=c1.getMethod("show");
        Method m2=c2.getDeclaredMethod("show",String.class);
        m2.setAccessible(true);
        m1.invoke(s1);
        m2.invoke(s1,"张三");
        System.out.println(m1);
        System.out.println(m2);


        saveFramework.save(s1);


    }
}

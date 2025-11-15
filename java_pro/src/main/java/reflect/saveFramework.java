package reflect;

import java.io.PrintStream;
import java.lang.reflect.Field;

public class saveFramework {
    public static void save(Object object) throws Exception {
        PrintStream ps=new PrintStream("src/main/java/reflect/example.txt");
        Class c1=object.getClass();
        String simpleName = c1.getSimpleName();
        System.out.println("保存对象："+simpleName);
        ps.println("============="+simpleName+"===============");
        //获取所有属性
        Field[] f1 = c1.getDeclaredFields();
        for(Field f:f1){
            f.setAccessible(true);
            String name=f.getName();
            Object value=f.get(object);
            System.out.println(name+"--"+value);
            ps.println(name+"--"+value);
            System.out.println("保存成功");
        }
    }
}

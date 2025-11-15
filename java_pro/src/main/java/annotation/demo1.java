package annotation;

@A(name="demo1",age=20)
public class demo1 {
    @A(name="demo2",age=30)
    public static void test() {
        System.out.println("test");
    }
}

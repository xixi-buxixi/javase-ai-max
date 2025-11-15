package proxy;

public class Test {
    public static void main(String[] args) {
        Star star=new Star("李健","男");
        //生成一个代理对象
        ProxyUtils proxy=new ProxyUtils();
        action proxyStar=proxy.createProxy(star);
        proxyStar.sing();
        proxyStar.dance();
    }
}

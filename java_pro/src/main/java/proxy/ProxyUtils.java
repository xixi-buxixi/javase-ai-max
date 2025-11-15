package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {
    public static action createProxy(Star s){
        action proxy=(action) Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(),
                s.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*参数一：代理对象
                        * 参数二：方法对象
                        * 参数三：方法参数
                        * */
                        String name=method.getName();
                        if(name.equals("sing")){
                            System.out.println("准备唱歌的场地中————");
                        }else if(name.equals("dance")){
                            System.out.println("准备跳舞的场地中————");
                        }
                        Object invoke = method.invoke(s, args);
                        return invoke;
                    }
                });
                return proxy;
    }
}

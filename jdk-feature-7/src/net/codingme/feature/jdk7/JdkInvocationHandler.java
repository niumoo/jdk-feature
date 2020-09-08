package net.codingme.feature.jdk7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理
 * Dynamic proxy
 */
public class JdkInvocationHandler implements InvocationHandler {

    private Object receiverObject;

    public JdkInvocationHandler(Object receiverObject) {
        this.receiverObject = receiverObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用的方法：" + method.getName() + "，参数是：" + Arrays.deepToString(args));
        return method.invoke(receiverObject, args);
    }
}

class SimpleProxy {
    public static void main(String[] args) {
        String str = "hello world";
        JdkInvocationHandler invocationHandler = new JdkInvocationHandler(str);
        ClassLoader classLoader = SimpleProxy.class.getClassLoader();
        Comparable proxyInstance = (Comparable)Proxy.newProxyInstance(classLoader, new Class[] {Comparable.class}, invocationHandler);
        int compare = proxyInstance.compareTo("Goood");
        System.out.println(compare);

        Comparable comparable = markProxy(Comparable.class, str);
        System.out.println(comparable.compareTo("1"));
    }

    /**
     * 为任何接口以及实现类创建代理工厂方法
     */
    public static <T> T markProxy(Class<T> intf, final T object) {
        JdkInvocationHandler invocationHandler = new JdkInvocationHandler(object);
        ClassLoader classLoader = SimpleProxy.class.getClassLoader();
        T proxyInstance = (T)Proxy.newProxyInstance(classLoader, new Class[] {intf}, invocationHandler);
        return proxyInstance;
    }
}

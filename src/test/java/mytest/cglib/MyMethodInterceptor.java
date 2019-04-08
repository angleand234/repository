package mytest.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
/**
 * �Զ���MethodInterceptor
 */
public class MyMethodInterceptor implements MethodInterceptor{
    /**
     * sub��cglib���ɵĴ������
     * method����������󷽷�
     * objects���������
     * methodProxy: ������
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======����ǰ��֪ͨ======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======�������֪ͨ======");
        return object;
    }
}


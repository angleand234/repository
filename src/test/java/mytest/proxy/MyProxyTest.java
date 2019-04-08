package mytest.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
* ʹ��JDK��̬����������:
* 1.ͨ��ʵ��InvocationHandler�ӿ����Զ����Լ���InvocationHandler;
* 2.ͨ��Proxy.getProxyClass��ö�̬������
* 3.ͨ��������ƻ�ô�����Ĺ��췽��������ǩ��ΪgetConstructor(InvocationHandler.class)
* 4.ͨ�����캯����ô�����󲢽��Զ����InvocationHandlerʵ������Ϊ��������
* 5.ͨ������������Ŀ�귽��
*/
public class MyProxyTest {
   @SuppressWarnings({ "rawtypes", "unchecked" })
public static void main(String[] args)
           throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
       // =========================��һ��==========================
       // 1������$Proxy0��class�ļ�
       System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
       // 2����ȡ��̬������
       Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
       // 3����ô�����Ĺ��캯�����������������InvocationHandler.class
       Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
       // 4��ͨ�����캯����������̬������󣬽��Զ����InvocationHandlerʵ������
       IHello iHello1 = (IHello) constructor.newInstance(new MyInvocationHandler(new HelloImpl()));
       // 5��ͨ������������Ŀ�귽��
       iHello1.sayHello();
       // ==========================�ڶ���=============================
       /**
        * Proxy���л��и���2~4�����װ�õļ�㷽����������̬�������
        *�䷽��ǩ��Ϊ��newProxyInstance(ClassLoader loader,Class<?>[] instance, InvocationHandler h)
        */
       IHello  iHello2 = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), // ���ؽӿڵ��������
               new Class[]{IHello.class}, // һ��ӿ�
               new MyInvocationHandler(new HelloImpl())); // �Զ����InvocationHandler
       iHello2.sayHello();
   }

}

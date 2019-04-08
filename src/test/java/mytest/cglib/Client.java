package mytest.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Client {
	public static void main(String[] args) {
		// ������class�ļ����뱾�ش��̷������Ƿ�����鿴Դ��
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
		// ͨ��CGLIB��̬�����ȡ�������Ĺ���
		Enhancer enhancer = new Enhancer();
		// ����enhancer����ĸ���
		enhancer.setSuperclass(HelloService.class);
		// ����enhancer�Ļص�����
		enhancer.setCallback(new MyMethodInterceptor());
		// �����������
		HelloService proxy = (HelloService) enhancer.create();
		// ͨ������������Ŀ�귽��
		proxy.sayHello();
	}
}

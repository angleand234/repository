package mytest.cglib;

public class HelloService {

    public HelloService() {
        System.out.println("HelloService����");
    }

    /**
     * �÷������ܱ����า��,Cglib���޷�����final���εķ�����
     * @param name
     * @return
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }

    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}

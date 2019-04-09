package mytest.Nio;

public class TimeClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

    int port = 1234;
    if (args != null && args.length > 0) {
        try {
        port = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
        // ����Ĭ��ֵ
        }
    }
    new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001")
        .start();
    }
}

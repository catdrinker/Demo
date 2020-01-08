package queue;

public class Main {
    // 移位操作，可理解为 n * 2^m ， 曲中对于>>>而言，是无符号数的计算，>>则是有符号的移位
    private final static int value = 10081 ^ 10086;

    public static void main(String[] args) {
        System.out.println("value is " + value);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.yield();
                System.out.println("child thread is running ");
            }
        }).start();
    }

}

package join;

public class MyThread extends Thread {

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    volatile int value = -1;
}

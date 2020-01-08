package queue;

public class Lock {

    private final Object readLock = new Object();

    private final Object writeLock = new Object();

    public void write() throws InterruptedException {
        synchronized (readLock) {
            Thread.sleep(50);
            synchronized (writeLock) {
                System.out.println("i ' am write now");
            }
        }
    }

    public void read() throws InterruptedException {
        synchronized (writeLock) {
            Thread.sleep(50);
            synchronized (readLock) {
                System.out.println("i ' am read now");
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new Lock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("process finish");
    }


}

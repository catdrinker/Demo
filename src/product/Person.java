package product;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Person implements IPerson{

    private final static int MAX_NUM = 5;

    private int productNum = 0;

    private final Object lock = new Object();

    // 公平锁
    private final Lock mLock = new ReentrantLock(true);

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (productNum >= MAX_NUM) {
                // 释放锁
                System.out.println("max than box ");
                lock.wait();
            }
            productNum++;
            System.out.println("produce product " + productNum);
            lock.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (productNum == 0) {
                // 释放锁
                System.out.println("box is empty");
                lock.wait();
            }
            // 消费嘛
            productNum--;
            System.out.println("consume product" + productNum);
            lock.notifyAll();
        }
    }
}

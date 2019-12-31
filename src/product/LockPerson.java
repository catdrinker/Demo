package product;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPerson implements IPerson {

    private static final int MAX_NUM = 5;

    private int productNum = 0;

    // 公平锁
    private Lock mLock = new ReentrantLock(true);

    private Condition condition = mLock.newCondition();

    @Override
    public void produce() throws InterruptedException {
        try {
            mLock.lock();
            while (productNum >= MAX_NUM) {
                System.out.println("max than max size, just await");
                condition.await();
            }
            productNum++;
            System.out.println("after product num " + productNum);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }

    @Override
    public void consume() {
        try {
            mLock.lock();
            while (productNum <= 0) {
                System.out.println("no product in box , waiting for produce");
                condition.await();
            }
            productNum--;
            System.out.println("after consume product num " + productNum);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}

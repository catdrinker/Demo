package join;


/**
 * 模拟调用thread.join 场景
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程运行完成");
                    Thread currentThread = Thread.currentThread();
                    if (currentThread instanceof MyThread) {
                        MyThread myThread = (MyThread) currentThread;
                        synchronized (myThread) {
                            myThread.value = 0;
                            myThread.notifyAll();
                        }
                    }
                }
            });

            thread.start();

//            thread.join();
//            System.out.println("wait 结束，重新获得锁");

            // 这里只是释放锁，释放锁后进入对象的等待池当中。 当该对象的notifyAll() 被调用后，从对象的等待池进入锁池，竞争获取锁，
            // 竞争获取到锁以后，
            // 但是外层的for循环是没办法往下执行的。因为wait()不是跳出方法块，只是让出当前的锁，线程的计数器会指向当前执行的代码行数。主线程中，即wait()之后的代码不会被执行，也不会跳出循
            // 连while也不会再被多执行一步。这里加上while的原因是，当调用对象的notifyAll 之后， 会继续执行while循环，当不满足条件仍然继续wait()

            synchronized (thread) {
                System.out.println("thread is wait " + thread);
                while (thread.value != 0) {
                    System.out.println("not zero");
                    thread.wait();
                    System.out.println("wait 结束，重新获得锁");
                }
            }
        }

        System.out.println("主线程运行完毕");

    }
}

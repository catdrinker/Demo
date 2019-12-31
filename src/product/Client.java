package product;

/**
 * 生产者消费者模式，及wait/notifyAll应用
 */
public class Client {

    private static final Object lock = new Object();

    private static IPerson person;

    public static void main(String[] args) throws InterruptedException {
        IPerson person = new LockPerson();

        for (int i = 0; i < 500; i++) {
            new Thread(new product.Product(person, "生产者" + i)).start();
        }

        for (int i = 0; i < 500; i++) {
            new Thread(new product.Consumer(person, "生产者" + i)).start();
        }



        /*new Thread(() -> {
            synchronized (lock) {
                while (person != null) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                person = new product.Person();
                lock.notifyAll();
            }
        }).start();*/


    }

}

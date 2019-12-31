package handler;


/**
 * 模拟android中的handler线程通信机制
 */
public class Main {

    private volatile static Delivery delivery = null;

    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        ThreadManager.start(id);
        delivery = new Delivery(ThreadManager.get(id));
        delivery.sendMessage(() -> new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                int finalI = i;
                delivery.sendMessage(() -> System.out.println("hello " + Thread.currentThread().getName() + finalI));
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    delivery.sendMessage(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("hello last one");
                        }
                    });
                }
            }).start();
        }).start());


        ThreadManager.dispatch();
    }
}

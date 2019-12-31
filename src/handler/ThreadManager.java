package handler;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadManager {

    private static ThreadManager threadManager = new ThreadManager();

    private static ConcurrentHashMap<Long, Dispatcher> threadMap = new ConcurrentHashMap<>();

    public static ThreadManager getInstance() {
        return threadManager;
    }

    public static Dispatcher get(long pid) {
        return threadMap.get(pid);
    }

    public static void start(long pid) {
        if (pid == -1L) {
            throw new IllegalStateException("can't access thread pid is -1");
        }
        if (threadMap.get(pid) != null) {
            throw new IllegalStateException("can't init before start");
        }
        threadMap.put(pid, new Dispatcher());
    }

    public static void dispatch() {
        Dispatcher mDispatcher = get(Thread.currentThread().getId());
        final MessageQueue msgQueue = mDispatcher.messageQueue;
        while (true) {
            if (msgQueue == null) {
                System.out.println("msg is null");
                return;
            }
            Message next = msgQueue.next();
            if (next == null) {
                continue;
            }
            if (next.target != null) {
                next.target.dispatchMessage(next);
                next.recycler();
                msgQueue.recycleMsg(next);
            }
        }
    }

}

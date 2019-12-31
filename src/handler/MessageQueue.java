package handler;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {

    private final List<Message> list = new ArrayList<>();

    private final Object object = new Object();

    public void addMsg(Message msg) {
        synchronized (object) {
            list.add(msg);
        }
    }

    public Message next() {
        synchronized (object) {
            if (!list.isEmpty()) {
                return list.get(0);
            }
            return null;
        }
    }

    public void recycleMsg(Message msg) {
        synchronized (object) {
            list.remove(msg);
        }
    }

}

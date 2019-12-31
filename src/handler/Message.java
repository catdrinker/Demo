package handler;

public class Message {

    Runnable runnable;

    Object object;

    Delivery target;

    void recycler() {
        this.runnable = null;
        this.object = null;
        this.target = null;
    }


}

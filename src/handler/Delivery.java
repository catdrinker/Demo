package handler;

public class Delivery {

    private MessageQueue messageQueue;

    public Delivery(Dispatcher dispatcher) {
        this.messageQueue = dispatcher.messageQueue;
    }

    public void sendMessage(Runnable runnable) {
        Message message = wrapperRunnableAsMsg(runnable);
        sendMessage(message);
    }

    private Message wrapperRunnableAsMsg(Runnable runnable) {
        Message message = new Message();
        message.runnable = runnable;
        message.target = this;
        return message;
    }

    public void sendMessage(Message msg) {
        messageQueue.addMsg(msg);
    }

    public void dispatchMessage(Message message) {
        if (message.runnable != null) {
            message.runnable.run();
        } else {
            handlerMsg(message);
        }
    }

    public void handlerMsg(Message message) {

    }


}

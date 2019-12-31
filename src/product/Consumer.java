package product;

public class Consumer implements Runnable{
    private IPerson person;
    private String consumeName;

    public Consumer(IPerson person, String consumeName) {
        this.person = person;
        this.consumeName = consumeName;
    }

    @Override
    public void run() {
        try {
            person.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

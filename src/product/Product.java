package product;

public class Product implements Runnable{
    private IPerson person;
    private String productName;

    public Product(IPerson person, String productName) {
        this.person = person;
        this.productName = productName;
    }

    @Override
    public void run() {
        try {
            person.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

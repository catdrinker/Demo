package greedy;

public class Main {

    private int num_25 = 25;
    private int num_10 = 10;
    private int num_5 = 5;
    private int num_1 = 1;


    public int cash(int sum) {
        int exit = sum;

        int count = 0;
        while (exit - num_25 >= 0) {
            count++;
            exit = exit - num_25;
            System.out.println("- num_25, exit "+exit);
        }

        while (exit - num_10 >= 0) {
            count++;
            exit = exit - num_10;
            System.out.println("- num_10, exit "+exit);
        }

        while (exit - num_5 >= 0) {
            count++;
            exit = exit - num_5;
            System.out.println("- num_5, exit "+exit);
        }

        while (exit - num_1 >= 0) {
            count++;
            exit = exit - num_1;
            System.out.println("- num_1, exit "+exit);
        }

        return count;
    }


    public static void main(String[] args) {
        Main m = new Main();

        int cash = m.cash(41);
        System.out.println("after cash "+cash +" times ");
    }


}

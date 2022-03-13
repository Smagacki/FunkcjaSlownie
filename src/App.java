import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Slownie sl = new Slownie();
        Scanner sc = new Scanner(System.in);
        long number;

        do {
            number = sc.nextLong();
            System.out.println(sl.slownie(number));
        } while (number != 0);
    }
}

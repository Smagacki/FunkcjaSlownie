import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] txt = {"zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć",
                "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście",
                "siedemnaście", "osiemnaście", "dziewiętnaście"};

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder slownie = new StringBuilder("");

        if (x < 20) {
            slownie.append(txt[x]);
        }

        System.out.println(slownie);

    }
}

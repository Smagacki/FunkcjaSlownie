import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] txt = {"zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć",
                "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście",
                "siedemnaście", "osiemnaście", "dziewiętnaście"};

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder slownie = new StringBuilder("");
        String liczbaStr = Integer.toString(x);

        List<String> trojki = new ArrayList<>();


        String dwieOstatnie = liczbaStr.substring(1, 3);
        int dwieOstatnieInt = Integer.parseInt(dwieOstatnie);
        if (dwieOstatnieInt < 20) {
            slownie.append(" ").append(txt[dwieOstatnieInt]);
        }

        System.out.println(slownie);

    }
}

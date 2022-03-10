import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] ones = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem",
                "dziewięć", "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście",
                "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};

        String[] tens = {"dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt",
                "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};

        String[] hundreds = {"sto", "dwieście", "trzysta", "czterysta", "pięcset",
                "sześćset", "siedemset", "osiemset", "dziewięćset"};

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder result = new StringBuilder("");
        String numberStr = Integer.toString(x);

        List<String> threes = generateListOfThrees(numberStr);
        System.out.println(threes);

        String three = threes.get(0);
        int digit;
        String rest = "";

        if (three.length() == 3) {
            if(!three.startsWith("0")) {
                digit = Integer.parseInt(three.substring(0, 1));
                result.append(hundreds[digit - 1]);
                rest = three.substring(1);
            }
        } else {
            rest = three;
        }

        if (Integer.parseInt(rest) < 20) {
            digit = Integer.parseInt(rest);
        } else {
            digit = Integer.parseInt(rest.substring(0, 1));
            result.append(" ").append(tens[digit - 2]);
            digit = Integer.parseInt(rest.substring(1));
        }
        result.append(" ").append(digit > 0 ? ones[digit - 1] : "");

        System.out.println(result.toString().trim());
    }

    static List<String> generateListOfThrees(String number) {
        List<String> threes = new ArrayList<>();
        int len;
        String part;

        while (!number.equals("")) {
            len = number.length();

            if (len <= 3) {
                part = number;
                number = "";
            } else {
                part = number.substring(len - 3);
                number = number.substring(0, len - 3);
            }

            threes.add(part);
        }

        return threes;
    }
}

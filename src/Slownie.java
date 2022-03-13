import java.util.ArrayList;
import java.util.List;

public class Slownie {
    private final String[] ones = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem",
            "dziewięć", "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście",
            "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};

    private final String[] tens = {"dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt",
            "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};

    private final String[] hundreds = {"sto", "dwieście", "trzysta", "czterysta", "pięcset",
            "sześćset", "siedemset", "osiemset", "dziewięćset"};

    private final String[][] names = {{"tysiąc", "tysiące", "tysięcy"},
            {"milion", "miliony", "milionów"},
            {"miliard", "miliardy", "miliardów"},
            {"bilion", "biliony", "bilionów"},
            {"biliard", "biliardy", "biliardów"}};

    String slownie(long number) {
        StringBuilder finalResult = new StringBuilder();
        String numberStr = Long.toString(number);

        List<String> threes = generateListOfThrees(numberStr);
        System.out.println(threes);

        for (int i = 0; i < threes.size(); i++) {
            StringBuilder result = new StringBuilder();
            String three = threes.get(i);
            int digit = 0;
            String rest;

            if (three.length() == 3 && !three.startsWith("0")) {
                digit = Integer.parseInt(three.substring(0, 1));
                result.append(hundreds[digit - 1]);
                rest = three.substring(1);
            } else {
                rest = three;
            }

            if (!rest.equals("00") && !(rest.equals("1") && i > 0)) {
                if (Integer.parseInt(rest) < 20) {
                    digit = Integer.parseInt(rest);
                } else {
                    digit = Integer.parseInt(rest.substring(0, 1));
                    if (!result.isEmpty()) {
                        result.append(" ");
                    }
                    result.append(tens[digit - 2]);
                    digit = Integer.parseInt(rest.substring(1));
                }
                if(digit > 0) {
                    if (!result.isEmpty()) {
                        result.append(" ");
                    }
                    result.append(ones[digit - 1]);
                }
            }

            //dolożenie nazw wielokrotnosci tysięcy
            if (i > 0) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                if(!three.equals("000")) {
                    if (digit >= 5) {
                        result.append(names[i - 1][2]);
                    } else if (digit >= 2) {
                        result.append(names[i - 1][1]);
                    } else if (three.length() > 1) {
                        result.append(names[i - 1][2]);
                    } else {
                        result.append(names[i - 1][0]);
                    }
                    if (!finalResult.isEmpty()) {
                        finalResult.append(" ");
                    }
                    finalResult.insert(0, " ");
                }
            }

            finalResult.insert(0, result);
        }
        return finalResult.toString().trim();
    }

    private List<String> generateListOfThrees(String number) {
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

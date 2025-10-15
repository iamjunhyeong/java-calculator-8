package calculator;

import java.util.ArrayList;

public class Parse {

    private String DELIMITER = ",|:";

    public Parse() {
        System.out.println("Parse class instantiated");
    }

    public String[] parse(String str) {
        String[] tokens = str.split(DELIMITER);
        return tokens;
    }

    public ArrayList<Integer> toIntArray(String[] tokens) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + token);
            }
        }
        return numbers;
    }
}

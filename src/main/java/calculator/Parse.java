package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.+)\\n(.*)";

    public Parse() {
        System.out.println("Parse class instantiated");
    }

    public String[] parse(String str) {
        str = str
                .replace("\\n", "\n")
                .replace("\\t", "\t")
                .replace("\\r", "\r")
                .replace("\\\\", "\\");

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(str);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbersPart = matcher.group(2);
            return numbersPart.split(Pattern.quote(customDelimiter));
        }

        return str.split(DEFAULT_DELIMITER);
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

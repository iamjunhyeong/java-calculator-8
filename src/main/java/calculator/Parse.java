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
        if (str == null || str.isBlank()) {
            return new String[0];
        }

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
            token = token.trim();
            if (token.isEmpty()) continue;

            int num;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }

            numbers.add(num);
        }
        return numbers;
    }
}

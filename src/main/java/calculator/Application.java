package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Parse parse = new Parse();
        Calculator calculate = new Calculator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("입력하세요: ");
        String input = scanner.nextLine();

        Input str = new Input(input);
        String[] tokens = parse.parse(str.getStr());
        ArrayList<Integer> numbers = parse.toIntArray(tokens);
        int result = calculate.sum(numbers);

        System.out.println(result);
    }
}

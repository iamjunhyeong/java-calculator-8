package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Parse parse = new Parse();
        Calculator calculate = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String input = Console.readLine();

        Input str = new Input(input);
        String[] tokens = parse.parse(str.getStr());
        ArrayList<Integer> numbers = parse.toIntArray(tokens);
        int result = calculate.sum(numbers);

        System.out.println("결과 : " + result);
    }
}

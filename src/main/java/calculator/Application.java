package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            Parse parse = new Parse();
            Calculator calc = new Calculator();

            String[] tokens = parse.parse(input);
            ArrayList<Integer> numbers = parse.toIntArray(tokens);
            int result = calc.sum(numbers);

            System.out.println("결과 : " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("에러 발생: " + e.getMessage());
            throw e; // 테스트 검증용으로 다시 던짐
        }
    }
}

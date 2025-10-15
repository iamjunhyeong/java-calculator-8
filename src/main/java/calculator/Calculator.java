package calculator;

import java.util.ArrayList;

public class Calculator {

    public Calculator() {
        System.out.println("Calculate class instantiated");
    }

    public int sum(ArrayList<Integer> numbers) {
        int total = 0;
        for (int n : numbers) {
            try {
                total = Math.addExact(total, n);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("총합이 int 범위를 초과했습니다.");
            }
        }
        return total;
    }
}

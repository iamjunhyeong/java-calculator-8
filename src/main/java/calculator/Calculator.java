package calculator;

import java.util.ArrayList;

public class Calculator {

    public Calculator() {
        System.out.println("Calculate class instantiated");
    }

    public int sum(ArrayList<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}

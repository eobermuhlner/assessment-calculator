package assessment.main;

import assessment.calculator.CalculatorService;
import assessment.calculator.CalculatorServiceImpl;

public class CalculatorApplication {

    private CalculatorService calculator = new CalculatorServiceImpl();

    private CalculatorApplication() {
        calculator = new CalculatorServiceImpl();
    }

    /**
     *
     * @param left
     * @param operation
     * @param right
     */
    private void calculate(String left, String operation, String right) {
        String result = calculator.calculate(left, operation, right);

        // string result = string.format("result: {0} {1} {2} = {4}"
        System.out.println("Result: " + left + " " + operation + " " + right + " = " + result);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CalculatorApplication application = new CalculatorApplication();

        String left = args[0];
        String operation = args[1];
        String right = args[2];

        application.calculate(left, operation, right);
    }
}

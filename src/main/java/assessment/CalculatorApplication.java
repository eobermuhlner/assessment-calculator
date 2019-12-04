package assessment;

public class CalculatorApplication {

    CalculatorServiceImpl calculator = new CalculatorServiceImpl();

    CalculatorApplication() {
        calculator = new CalculatorServiceImpl();
    }

    public void calculate(String left, String operation, String right) {
        String result = calculator.calculate(left, operation, right);

        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        CalculatorApplication application = new CalculatorApplication();

        application.calculate(args[2], args[1], args[0]);
    }
}

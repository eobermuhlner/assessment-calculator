package assessment;

public class CalculatorApplication {

    private CalculatorServiceImpl calculator = new CalculatorServiceImpl();

    CalculatorApplication() {
        calculator = new CalculatorServiceImpl();
    }

    private String calculate(String left, String operation, String right) {
        String result = calculator.calculate(left, operation, right);
        return result;
        //System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        CalculatorApplication application = new CalculatorApplication();
        String result = application.calculate(args[2], args[1], args[0]);
        System.out.println("Result " + result);
    }
}

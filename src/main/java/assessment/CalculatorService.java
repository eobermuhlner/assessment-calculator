package assessment;

public interface CalculatorService {

    /**
     * Calculates the result of the mathematical expression defined in the arguments.
     *
     * It supports the operations + - * /
     *
     * @param elements the expression
     * @return the result of the expression
     */
    String calculate(String elements[]);
}

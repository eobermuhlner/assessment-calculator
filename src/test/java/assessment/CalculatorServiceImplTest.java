package assessment;

import org.junit.Test;

public class CalculatorServiceImplTest {

    @Test
    public void testCalculate() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

        calculatorService.calculate("2", "+", "2");
        calculatorService.calculate("2", "*", "2");
        calculatorService.calculate("2", "-", "2");
        calculatorService.calculate("2", "/", "2");
    }
}

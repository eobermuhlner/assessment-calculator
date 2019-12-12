package assessment;

import assessment.calculator.CalculatorService;
import assessment.calculator.CalculatorServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService;
    private double precision = 0.00000001d;

    @Before
    public void initialize() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void testSetAndGetVariable() {
        boolean updated = calculatorService.setVariable("left", "123.0");
        assertEquals(false, updated);

        assertEquals("123.0", calculatorService.getVariable("left"));

        updated = calculatorService.setVariable("left", "123.0");
        assertEquals(true, updated);
    }

    @Test
    public void testRemoveVariable(){
        boolean updated = calculatorService.setVariable("left", "123.0");
        boolean removed = calculatorService.removeVariable("left");
        assertEquals(true, removed);

        assertEquals(null, calculatorService.getVariable("left"));

        removed = calculatorService.removeVariable("left");
        assertEquals(false, removed);

        removed = calculatorService.removeVariable("right");
        assertEquals(false, removed);
    }

    @Test
    public void testAddition() {
        calculatorService.setVariable("left", "2");
        calculatorService.setVariable("right", "2");

        String result = calculatorService.calculate("left", "+", "right");
        assertEquals("4.0", result);

        result = calculatorService.calculate("3", "+", "3");
        assertEquals("6.0", result);
    }

    @Test
    public void testSubtract() {
        calculatorService.setVariable("left", "2");
        calculatorService.setVariable("right", "2");

        String result = calculatorService.calculate("left", "-", "right");
        assertEquals("0.0", result);

        result = calculatorService.calculate("3", "-", "10.5454");
        assertEquals(Double.parseDouble("-7.5454"), Double.parseDouble(result), precision);
    }

    @Test
    public void testMultiply() {
        calculatorService.setVariable("left", "2");
        calculatorService.setVariable("right", "25.5");

        String result = calculatorService.calculate("left", "*", "right");
        assertEquals("51.0", result);

        result = calculatorService.calculate("3", "*", "10.5454");
        assertEquals(Double.parseDouble("31.6362"), Double.parseDouble(result), precision);
    }

    @Test
    public void testDivide() {
        calculatorService.setVariable("left", "255.0");
        calculatorService.setVariable("right", "25.5");

        String result = calculatorService.calculate("left", "/", "right");
        assertEquals("10.0", result);

        result = calculatorService.calculate("3", "/", "-2.0");
        assertEquals(Double.parseDouble("-1.5"), Double.parseDouble(result), precision);
    }

    @Test
    public void testDivisionByZero() {
        calculatorService.setVariable("left", "255.0");
        calculatorService.setVariable("right", "0");

        String result = calculatorService.calculate("left", "/", "right");
        assertEquals("Error - Division by zero", result);

        result = calculatorService.calculate("3", "/", "-.0");
        assertEquals("Error - Division by zero", result);
    }

    @Test
    public void testUnknownOperation() {
        calculatorService.setVariable("left", "255.0");
        calculatorService.setVariable("right", "0");

        String result = calculatorService.calculate("left", "unknown", "right");
        assertEquals("Error - unknown operator", result);

        result = calculatorService.calculate("3", "unknown", "-.0");
        assertEquals("Error - unknown operator", result);
    }

    @Test
    public void testInvalidNumber() {
        calculatorService.setVariable("left", "Invalid");
        calculatorService.setVariable("right", "0");

        String result = calculatorService.calculate("left", "+", "right");
        assertEquals("Error - Invalid number", result);

        result = calculatorService.calculate("3", "-", "NotaNumber");
        assertEquals("Error - Invalid number", result);
    }

    @Test
    public void testSetViaCalculator()
    {
        String result = calculatorService.calculate("set", "left", "123.0");
        assertEquals("Created", result);

        assertEquals("123.0", calculatorService.getVariable("left"));

        result = calculatorService.calculate("set", "left", "124.0");
        assertEquals("Updated", result);

        assertEquals("124.0", calculatorService.getVariable("left"));
    }

    @Test
    public void testRemoveViaCalculator()
    {
        String result = calculatorService.calculate("remove", "left");
        assertEquals("Didn't exist", result);

        result = calculatorService.calculate("set", "left", "124.0");
        assertEquals("Created", result);

        result = calculatorService.calculate("remove", "left");
        assertEquals("Removed", result);

        assertEquals(null, calculatorService.getVariable("left"));
    }

}

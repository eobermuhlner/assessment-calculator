package assessment.calculator;

import assessment.numberservice.NumberService;
import assessment.numberservice.NumberServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class CalculatorServiceImpl implements CalculatorService {

    private NumberService numberService = new NumberServiceImpl();

    private Map<String, String> variables = new HashMap<>();

    public CalculatorServiceImpl() {
        variables.put("pi", Double.toString(Math.PI));
        variables.put("e", Double.toString(Math.E));
    }

    public boolean setVariable(String name, String value) {
        boolean oldVariable = variables.containsKey(name);

        variables.put(name, value);
        return oldVariable;
    }

    public boolean removeVariable(String name) {
        return variables.remove(name) != null;
    }

    public String getVariable(String name) {
        return variables.get(name);
    }

    public String calculate(String... elements) {
        if (elements[0].equals("set")) {
            boolean updated = setVariable(elements[1], elements[2]);
            return updated ? "Updated" : "Created";
        }

        if (elements[0].equals("remove")) {
            boolean existed = removeVariable(elements[1]);
            return existed ? "Removed" : "Didn't exist";
        }

        try {
            double v1 = convertToDouble(elements[0]);
            double v2 = convertToDouble(elements[2]);

            switch (elements[1]) {
                case "-":
                case "subtract":
                case "minus":
                    return Double.toString(v1 - v2);
                case "*":
                    return Double.toString(v1 * v2);
                case "/":
                    if (v2 == 0.0d) {
                        return "Error - Division by zero";
                    }

                    return Double.toString(v1 / v2);
                case "+":
                    return Double.toString(v1 + v2);
                default:
                    return "Error - unknown operator";
            }
        } catch (NumberFormatException ex) {
            return "Error - Invalid number";
        }
    }

    private double convertToDouble(String string) {
        if (variables.containsKey(string)) {
            return numberService.convertToDouble(variables.get(string));
        }

        return numberService.convertToDouble(string);
    }
}

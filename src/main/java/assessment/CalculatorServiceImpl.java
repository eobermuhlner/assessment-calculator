package assessment;

import java.util.HashMap;

public class CalculatorServiceImpl implements CalculatorService {

    private NumberServiceImpl numberService = new NumberServiceImpl();

    private HashMap<String, String> variables = new HashMap<>();

    private void setVar(String name, String value) {
        variables.put(name, value);
    }

    private String unsetVar(String name) {
        String s = "";
        if (variables.containsKey(name)) {
            s = variables.get(name);
            variables.remove(name);
        }
        return s;
    }

    public String calculate(String elem1, String elem2, String elem3) {
        String[] elems = new String[3];
        elems[0] = elem1;
        elems[1] = elem2;
        elems[2] = elem3;
        return calculate(elems);
    }

    /**
     *
     * @param elements the expression
     * @return
     *
     * set name value ...
     * set hello 123
     * hello + 4
     * hello2 + 4
     */
    public String calculate(String[] elements) throws NumberFormatException, UnknownOperatorException {
        if (elements[0].equals("set")) {
            setVar(elements[1], elements[2]);
            return String.valueOf(elements[2]);
        }

        if (elements[0].equals("unset")) {
            unsetVar(elements[0]);
            return String.valueOf(elements[0]);
        }

        String firstOperand = getValueFromDictionary(elements[0]);
        String secondOperand = getValueFromDictionary(elements[2]);
        double v1 = convertToDouble(firstOperand);
        double v2 = convertToDouble(secondOperand);


        if (elements[1].equals("-")) {
            return String.valueOf(v1 - v2);
        } else if (elements[1].equals("*")) {
            return String.valueOf(v1 * v2);
        } else if (elements[1].equals("/")) {
            //todo v2 0
            return String.valueOf(v1  / v2);
        } else if (elements[1].equals("+")) {
            return String.valueOf(v1 + v2);
        }

        throw new UnknownOperatorException("Unknown op" + elements[1]);

    }

    private String getValueFromDictionary(String element) {
        if (variables.containsKey(element)){
            return variables.get(element);
        }
        return element;
    }

    private double convertToDouble(String string) throws NumberFormatException {
        if (string.equals("pi")) {
            return 3.1415;
        }
        return numberService.convertToDouble(string);
    }
}

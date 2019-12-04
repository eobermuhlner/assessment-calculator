package assessment;

import java.util.HashMap;

public class CalculatorServiceImpl {

    public NumberServiceImpl numberService = new NumberServiceImpl();

    public HashMap variables = new HashMap();

    public void setVar(String name, String value) {
        variables.put(name, value);
    }

    public void unsetVar(String name) {
        for (Object key : variables.keySet()) {
            if (name.equals(key)) {
                variables.remove(key);
            }
        }
    }

    public String calculate(String... elements) {
        if (elements[0].equals("set")) {
            setVar(elements[1], elements[2]);
            return "";
        }

        if (elements[0].equals("unset")) {
            unsetVar(elements[1]);
        }

        double v1 = convertToDouble(elements[0]);
        double v2 = convertToDouble(elements[2]);

        if (elements[1] == "-") {
            return new String(new Double(v1 - v2).toString());
        } else if (elements[1] == "*") {
            return new String(new Double(v1 * v2).toString());
        } else if (elements[1] == "/") {
            return new String(new Double(v1 / v2).toString());
        } else {
            return new String(new Double(v1 + v2).toString());
        }
    }

    public double convertToDouble(String string) {
        if (string == "pi") {
            return 3.1415;
        }
        return numberService.convertToDouble(string);
    }
}

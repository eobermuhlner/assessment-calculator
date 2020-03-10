package assessment;

public interface NumberService {

    /**
     * Converts a string into a double number.
     *
     * @param string the string to convert
     * @return the double number
     */
    double convertToDouble(String string) throws NumberFormatException;
}

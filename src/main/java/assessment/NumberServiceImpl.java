package assessment;

public class NumberServiceImpl implements NumberService {

    public double convertToDouble(String string) throws NumberFormatException {
        return Double.parseDouble(string);
    }
}

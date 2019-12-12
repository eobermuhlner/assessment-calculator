package assessment.numberservice;

public class NumberServiceImpl implements NumberService {

    public Double convertToDouble(String string) {
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException ex) {
            System.out.println(string + " is not a double");
            throw ex;
        }
    }
}

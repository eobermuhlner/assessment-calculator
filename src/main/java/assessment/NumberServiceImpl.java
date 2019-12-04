package assessment;

public class NumberServiceImpl implements NumberService {

    @Override
    public Double convertToDouble(String string) {
        return Double.parseDouble(string);
    }
}

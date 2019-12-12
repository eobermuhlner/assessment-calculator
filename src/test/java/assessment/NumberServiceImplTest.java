package assessment;

import assessment.numberservice.NumberService;
import assessment.numberservice.NumberServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberServiceImplTest {

    private NumberService numberService;
    private double precision = 0.00000001d;

    @Before
    public void initialize() {
        numberService = new NumberServiceImpl();
    }

    @Test
    public void testConvertToDouble() {
        Double res = numberService.convertToDouble("123");
        assertEquals(123.0d, res, 0.000001);
    }

    @Test(expected = NumberFormatException.class)
    public void testParsingError() {
        numberService.convertToDouble("blah blah");
    }
}

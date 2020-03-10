package assessment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberServiceImplTest {

    @Test
    public void testConvertToDouble() {
        NumberServiceImpl numberServiceImpl = new NumberServiceImpl();

       Double d = numberServiceImpl.convertToDouble("123");
       assertEquals("d should", 123.0, d.doubleValue(), 0.00001);
    }
}

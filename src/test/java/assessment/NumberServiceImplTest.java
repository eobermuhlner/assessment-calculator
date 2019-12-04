package assessment;

import org.junit.Test;

public class NumberServiceImplTest {

    @Test
    public void testConvertToDouble() {
        NumberServiceImpl numberServiceImpl = new NumberServiceImpl();

        numberServiceImpl.convertToDouble("123");
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void testAddShouldReturn0() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
    @Test
    public void testAddShouldReturn1() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }
    @Test
    public void testAddShouldReturn3() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
    @Test
    public void testAddShouldReturnError()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(Integer.MIN_VALUE, calculator.add("1,2,sometext"));
    }
}

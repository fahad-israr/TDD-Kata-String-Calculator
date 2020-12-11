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
    public void testAddShouldReturnNegativeInfinity()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(Integer.MIN_VALUE, calculator.add("1,2,sometext"));
    }
    @Test
    public void testAddShouldReturn6()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }
    @Test
    public void testAddShouldReturn3withCustomDelimiter()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }
    @Test
    public void testAddShouldReturnException(){
        StringCalculator calculator = new StringCalculator();
    	try {
			calculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }
    @Test
    public void testAddShouldReturn2()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("1001,2"));
    }
    @Test
    public void testAddShouldReturn6withAnyDelimiterLength()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void testAddShouldReturn6withMutipleDelimiter()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }
}

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Rule

    public ExpectedException thrown = ExpectedException.none();
    @Before

    public void initialize() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldReturn0() {
        assertEquals(calculator.Add(""), 0);
    }

    @Test
    public void numberStringShouldReturnSameNumber() {
        assertEquals(calculator.Add("9"), 9);
        assertEquals(calculator.Add("8"), 8);
    }

    @Test
    public void numbersCommaDelimitedShouldBeSummed() {
        assertEquals(calculator.Add("6,2"), 8);
        assertEquals(50, calculator.Add("40,10"));
    }

    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
        assertEquals(calculator.Add("80\n69"), 149);
        assertEquals(calculator.Add("55\n25"), 80);
    }

    @Test
    public void threeNumbersDelimitedAnywayShouldBeSummed() {
        assertEquals(calculator.Add("100,100,100"), 300);
        assertEquals(calculator.Add("59\n2\n30"), 91);
    }

    @Test
    public void negativeInputReturnsException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("negatives not allowed");
        calculator.Add("-15");
        calculator.Add("-15,10\n-15");
    }

    @Test
    public void specialCharacters(){

        assertEquals(calculator.Add("//[***]\\n1***2***3"),6);
        assertEquals(calculator.Add("//[*][%]\\n1*2%3"),6);
    }
    @Test
    public void numbersGreaterThan1000AreIgnored() {
        assertEquals(calculator.Add("5,125,1001"), 130);
        assertEquals(calculator.Add("14124,23\n40,1214"), 63);
    }



}

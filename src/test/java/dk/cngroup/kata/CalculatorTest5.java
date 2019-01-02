package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest5 {
  private Calculator5 cal = new Calculator5();


  @Test
  public void shouldReturn0ByDefault(){
    assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(5,cal.add("5"));
    assertEquals(0,cal.add("0"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers(){
    assertEquals(7,cal.add("5,2"));
    assertEquals(1,cal.add("0,1"));
  }

  @Test
  public void shouldReturnSumWhenMoreNumbers(){
    assertEquals(16,cal.add("5,2,5,3,1"));
    assertEquals(42,cal.add("0,1,1,40"));
  }

  @Test
  public void shouldReturnSumWhenDifferentDelimiters(){
    assertEquals(16,cal.add("5\n2,5,3,1"));
    assertEquals(42,cal.add("0,1,1\n40"));
  }

  @Rule
  public ExpectedException ExpectedEx = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInRow(){
    ExpectedEx.expect(RuntimeException.class);
    ExpectedEx.expectMessage("Delimiter issue");
    cal.add("0,1,1,\n40");
  }

  @Test
  public void shouldReturnSumWhenCustomDelimiter(){
    assertEquals(16,cal.add("//;\n5\n2;5,3,1"));
    assertEquals(72,cal.add("//.\n0\n55,3.2,12"));
  }

  @Test
  public void shouldFailWhenNegativeNumbers(){
    ExpectedEx.expect(RuntimeException.class);
    ExpectedEx.expectMessage("negatives not allowed");
    cal.add("//.\n0\n-55,-3.2,-12");
  }
}

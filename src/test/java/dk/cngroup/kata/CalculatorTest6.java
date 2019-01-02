package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest6 {

  private Calculator6 cal = new Calculator6();

  @Test
  public void shouldReturn0WhenDefault(){
      assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(2,cal.add("2"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers(){
    assertEquals(3,cal.add("1,2"));
    assertEquals(33,cal.add("13,20"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters(){
    assertEquals(30,cal.add("3,6\n9,12"));
    assertEquals(34,cal.add("13,20,1\n0"));
  }

  @Rule
  public ExpectedException ExpExc = ExpectedException.none();

  @Test
  public void sholdFailWhen2DelimitersInRow(){
    ExpExc.expect(RuntimeException.class);
    ExpExc.expectMessage("2 Delimiters in a row");
    cal.add("13,20,1,\n0");
  }

  @Test
  public void sholdReturnSumWhenDefinedDelimiter(){
    assertEquals(30,cal.add("//;\n3,6\n9;12"));
    assertEquals(30,cal.add("//.\n3.6\n9.12"));
  }

  @Test
  public void sholdFailWhenNegativeNumbers(){
    ExpExc.expect(RuntimeException.class);
    ExpExc.expectMessage("negatives are not allowed");
    cal.add("//;\n-3,6\n9;-12");
  }
}

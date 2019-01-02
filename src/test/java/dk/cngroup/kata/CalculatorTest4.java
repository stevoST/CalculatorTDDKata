package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest4 {

  private Calculator4 cal = new Calculator4();

  @Test
  public void shouldReturn0ByDefault(){
    assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(4,cal.add("4"));
    assertEquals(50,cal.add("50"));
  }

  @Test
  public void shouldReturnSumWehn2Numbers(){
    assertEquals(5,cal.add("4,1"));
    assertEquals(54,cal.add("50,4"));
  }

  @Test
  public void shouldReturnSumWhenMoreNumbers(){
    assertEquals(19,cal.add("3,5,6,4,1"));
    assertEquals(57,cal.add("0,1,2,50,4"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters(){
    assertEquals(19,cal.add("3,5,6\n4,1"));
    assertEquals(57,cal.add("0\n1,2,50,4"));
  }

  @Rule
  public ExpectedException ExpectEx = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInRow() {
    ExpectEx.expect(RuntimeException.class);
    ExpectEx.expectMessage("Incorrect delimiters");
    cal.add("3,5,6\n,4,1");
  }

  @Test
  public void shouldReturnSumWhenUserDefinedDelimiter(){
    ExpectEx.expect(RuntimeException.class);
    ExpectEx.expectMessage("negatives not allowed");
    cal.add("//;\n3;-5;6;4,1");
  }

  @Test
  public void shouldReturnSumWhenUserDefinedDelimiter2() {
    ExpectEx.expect(RuntimeException.class);
    ExpectEx.expectMessage("negatives not allowed");
    cal.add("//.\n0.1,-2,-50,4");
  }

}

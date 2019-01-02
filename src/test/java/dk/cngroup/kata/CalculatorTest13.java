package dk.cngroup.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest13 {

  private Calculator13 cal = new Calculator13();

  @Test
  public void shouldReturn0WhenDefault() {
    assertEquals(0, cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number() {
    assertEquals(0, cal.add("0"));
    assertEquals(41, cal.add("41"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers() {
    assertEquals(3, cal.add("1,2"));
    assertEquals(45, cal.add("41,4"));
  }


  @Test
  public void shouldReturnSumWhenMoreNumbers() {
    assertEquals(20, cal.add("1,2,4,5,6,2"));
    assertEquals(59, cal.add("41,4,4,4,0,5,1"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters() {
    assertEquals(20, cal.add("1\n2,4,5\n6,2"));
    assertEquals(59, cal.add("41,4,4,4,0\n5\n1"));
  }

  @Rule
  public ExpectedException excep = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInARow() {
    excep.expect(RuntimeException.class);
    excep.expectMessage("2 Delimiters in a row");
    cal.add("41,4,4\n,4,0,5,1");
  }

  @Test
  public void shouldFailWhen2DelimitersInARow2() {
    excep.expect(RuntimeException.class);
    excep.expectMessage("2 Delimiters in a row");
    cal.add("41,4,4,\n4,0,5,1");
  }


  @Test
  public void shouldFailWhenNegativeNumbers() {
    excep.expect(RuntimeException.class);
    excep.expectMessage("Negatives are not allowed [-41, -4, -5]");
    cal.add("-41,4,4\n-4,0,-5,1");
  }

  @Test
  public void shoudReturnSumAndIgnoreNumbersOver1000() {
    assertEquals(1020, cal.add("1\n2,4,1000,5\n6,2"));
    assertEquals(59, cal.add("41,4,4,4,1001,0\n5\n1"));
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiter() {
    assertEquals(1020, cal.add("//;\n1\n2,4;1000,5\n6;2"));
    assertEquals(59, cal.add("//.\n41,4,4.4,1001,0\n5\n1"));
  }

  @Test
  public void shouldReturnSumWhenDellimiterHasDifferentSize() {
    assertEquals(1020, cal.add("//[;;]\n1\n2,4;;1000,5\n6;;2"));
    assertEquals(59, cal.add("//[..]\n41,4,4..4,1001,0\n5\n1"));
    assertEquals(59, cal.add("//[****]\n41,4,4****4,1001,0\n5****1"));
  }

  @Test
  public void shouldReturnSumWhenMultipleDellimiterHasDifferentSize() {
    assertEquals(59, cal.add("//[.][****][klobasa]\n41,4****4****4klobasa1001klobasa0.5\n1"));
  }

  }

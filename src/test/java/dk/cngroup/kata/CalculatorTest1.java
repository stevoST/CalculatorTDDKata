package dk.cngroup.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest1 {

  private Calculator1 cal = new Calculator1();

  @Test
  public void shouldReturn0WhenDefault() {
    assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(3,cal.add("3"));
    assertEquals(5,cal.add("5"));
    assertEquals(8,cal.add("8"));
  }

  @Test
  public void shouldReturnSumWhenNumbers(){
    assertEquals(5,cal.add("2,3"));
    assertEquals(8,cal.add("4,4"));
  }

  @Test
  public void shouldReturnSumWhenLotNumbers(){
    assertEquals(14,cal.add("2,3,6,3"));
    assertEquals(14,cal.add("4,4,2,1,3"));
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiters(){
    assertEquals(14,cal.add("2\n3,6,3"));
    assertEquals(14,cal.add("4,4,2\n1,3"));
  }

  @Test
  public void shouldReturn0When2DelimitersInRow() {
    assertEquals(0,cal.add("4,4,2,\n1,3"));
    assertEquals(0,cal.add("4,\n"));
  }

  @Test
  public void shouldReturnSumWhenUserDefinedDelimiter() {
    assertEquals(22,cal.add("//;\n4;2;2;1;13"));
  }
}


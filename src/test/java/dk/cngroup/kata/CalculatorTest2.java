package dk.cngroup.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest2 {

  private Calculator2 cal = new Calculator2();

  @Test
  public void shouldreturn0WhenDefault() {
    assertEquals(0, cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Input(){
    assertEquals(3, cal.add("3"));
    assertEquals(55, cal.add("55"));
  }

  @Test
  public void shuoldReturnSumWhen2Numbers(){
    assertEquals(10, cal.add("5,5"));
    assertEquals(5, cal.add("2,3"));
  }

  @Test
  public void shouldReturnSumWhenLotNumbers() {
    assertEquals(22, cal.add("3,4,5,10"));
    assertEquals(24, cal.add("1,0,5,18"));

  }

  @Test
  public void shouldReturnSumWhenNewLine(){
    assertEquals(6, cal.add("1\n2,3"));
    assertEquals(19, cal.add("1,2,3,5\n8"));

  }

  @Test
  public void shouldFailWhen2DelimitersInRow(){
    assertEquals(0, cal.add("1,\n"));
    assertEquals(0, cal.add("1\n,3"));
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiter() {
    assertEquals(3, cal.add("//;\n1;2"));
    assertEquals(19, cal.add("//.\n2.3.4.10"));
  }
}


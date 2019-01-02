package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest7 {

  private Calculator7 cal = new Calculator7();

  @Test
  public void shouldReturn0WhenDefault(){
    assertEquals(0,cal.add(""));
  }


  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(0,cal.add("0"));
    assertEquals(44,cal.add("44"));
  }

  @Test
  public void shouldReturnSumWhen2numbers(){
    assertEquals(1,cal.add("0,1"));
    assertEquals(48,cal.add("44,4"));
  }

  @Test
  public void shouldReturnSumWhenMorenumbers(){
    assertEquals(8,cal.add("0,1,3,4"));
    assertEquals(51,cal.add("44,4,1,2"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters(){
    assertEquals(8,cal.add("0,1\n3,4"));
    assertEquals(51,cal.add("44\n4\n1,2"));
  }

  @Rule
  public ExpectedException expExcept = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInARow(){
    expExcept.expect(RuntimeException.class);
    expExcept.expectMessage("2 Delimiters in a row");
    cal.add("44\n,4\n1,2");
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiters(){
    assertEquals(8,cal.add("//;\n0;1\n3;4"));
    assertEquals(51,cal.add("//.\n44\n4,1.2"));
  }


  @Test
  public void shouldFailWhenNegativeNumber(){
    expExcept.expect(RuntimeException.class);
    expExcept.expectMessage("Negatives are not allowed");
    cal.add("44\n-4\n1,-2,-80");
  }

}

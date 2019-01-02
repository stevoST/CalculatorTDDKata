package dk.cngroup.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest12 {

  private Calculator12 cal = new Calculator12();

  @Test
  public void shouldReturn0WhenDefualt(){
    assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(0,cal.add("0"));
    assertEquals(3,cal.add("3"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers(){
    assertEquals(5,cal.add("1,4"));
    assertEquals(48,cal.add("45,3"));
  }

  @Test
  public void shouldReturnSumWhenMoreNumbers(){
    assertEquals(12,cal.add("1,4,4,1,2"));
    assertEquals(58,cal.add("45,3,1,3,4,2"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters(){
    assertEquals(12,cal.add("1,4\n4,1,2"));
    assertEquals(58,cal.add("45,3\n1,3,4,2"));
  }

  @Rule
  public ExpectedException excep = ExpectedException.none();

  @Test
  public void shouldFailWheen2Delimiters(){
    excep.expect(RuntimeException.class);
    excep.expectMessage("2 delimiters in a row");
    cal.add("45,3\n,1,3,4,2");
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiter(){
    assertEquals(12,cal.add("//;\n1;4\n4,1,2"));
    assertEquals(58,cal.add("//.\n45.3\n1,3,4,2"));
  }

  @Test
  public void shouldFailWheenNegativeNumber(){
    excep.expect(RuntimeException.class);
    excep.expectMessage("negatives are not allowed [-45, -4, -2]");
    cal.add("-45,3\n1,3,-4,-2");
  }
}

package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest11 {

  private Calculator11 cal = new Calculator11();

  @Test
  public void shouldReturn0WhenDefault(){
  assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number(){
    assertEquals(0,cal.add("0"));
    assertEquals(41,cal.add("41"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers(){
    assertEquals(3,cal.add("1,2"));
    assertEquals(7,cal.add("4,3"));
  }

  @Test
  public void shouldReturnSumWhenMoreNumbers(){
    assertEquals(35,cal.add("1,2,6,1,23,2"));
    assertEquals(51,cal.add("4,3,0,14,25,5"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters(){
    assertEquals(35,cal.add("1,2,6\n1,23\n2"));
    assertEquals(51,cal.add("4\n3\n0,14,25,5"));
  }

  @Rule
  public ExpectedException except = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInRow(){
    except.expect(RuntimeException.class);
    except.expectMessage("2 delimiters in a row");
    cal.add("1,2,3,4,5123,2,\n3,2,1");
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiter(){
    assertEquals(35,cal.add("//;\n1;2,6\n1,23;2"));
    assertEquals(51,cal.add("//.\n4.3.0,14.25,5"));
  }

  @Test
  public void shouldFailWhenNegativeNumber(){
    except.expect(RuntimeException.class);
    except.expectMessage("negatives are not allowed [-2, -5123, -2, -1]");
    cal.add("1,-2,3,4,-5123,2\n3,-2,-1");
  }

  @Test
  public void shouldReturnSumOnlyWhenLessThan1001(){
    assertEquals(35,cal.add("1,2,6\n1,23,1001\n2"));
    assertEquals(1051,cal.add("4\n3\n0,14,25,1000,5"));
  }

}

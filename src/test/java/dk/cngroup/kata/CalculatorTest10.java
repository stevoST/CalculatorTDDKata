package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest10 {

  private Calculator10 cal = new Calculator10();

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
    assertEquals(3,cal.add("0,3"));
    assertEquals(44,cal.add("41,3"));
  }

  @Test
  public void shouldReturnSumWhenMoreNumbers(){
    assertEquals(26,cal.add("0,3,5,5,6,7"));
    assertEquals(60,cal.add("41,3,3,5,7,1"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters(){
    assertEquals(26,cal.add("0\n3,5\n5,6\n7"));
    assertEquals(60,cal.add("41\n3,3,5,7\n1"));
  }

  @Rule
  public ExpectedException except = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInRow(){
    except.expect(RuntimeException.class);
    except.expectMessage("2 delimiters in a row");
    cal.add("41,3,3\n,5,7,1");
  }


  @Test
  public void shouldReturnSumWhenDefinedDelimiter(){
    assertEquals(26,cal.add("//;\n0;3,5\n5;6\n7"));
    assertEquals(60,cal.add("//;\n41;3,3,5;7\n1"));
  }

  @Test
  public void shouldFailWhenNegativeNumbers(){
    except.expect(RuntimeException.class);
    except.expectMessage("Negatives are not allowed [-41, -7, -1]");
    cal.add("-41,3,3\n5,-7,-1");
  }
}

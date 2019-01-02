package dk.cngroup.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest9 {

  private Calculator9 cal = new Calculator9();

  @Test
  public void shouldReturn0WhenDefault() {
    assertEquals(0, cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number() {
    assertEquals(4, cal.add("4"));
    assertEquals(0, cal.add("0"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers() {
    assertEquals(6, cal.add("4,2"));
    assertEquals(10, cal.add("0,10"));
  }

  @Test
  public void shouldReturnSumWhenMoreNumbers() {
    assertEquals(24, cal.add("4,2,3,5,10"));
    assertEquals(20, cal.add("0,10,1,3,6"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters() {
    assertEquals(24, cal.add("4,2,3\n5,10"));
    assertEquals(20, cal.add("0,10\n1,3\n6"));
  }

  @Rule
  public ExpectedException except = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInARow() {
    except.expect(RuntimeException.class);
    except.expectMessage("2 Delimiters in a row");
    cal.add("0,10\n,1,3\n6");
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiter() {
    assertEquals(24, cal.add("//;\n4;2,3\n5;10"));
    assertEquals(20, cal.add("//;\n0;10\n1;3\n6"));
  }

  @Test
  public void shouldFailWhenNegativeNumber() {
    except.expect(RuntimeException.class);
    except.expectMessage("Negatives are not allowed [-10, -1, -6]");
    cal.add("0,-10\n-1,3\n-6");
  }

  @Test
  public void shouldIgnoreNumbersOver1000() {
    assertEquals(1024, cal.add("4,1000,2,3\n5,10"));
    assertEquals(20, cal.add("0,10\n1,3\n6,1001"));
  }

  @Test
  public void shouldReturnSumWhenLongDefinedDelimiter() {
    assertEquals(24, cal.add("//[***]\n4***2***3***5***10"));
    assertEquals(20, cal.add("//[***]\n0***10***1***3***6"));
  }

  @Test
  public void shouldReturnSumWhenLongDefinedDelimiter2() {
    assertEquals(24, cal.add("//[nie]\n4nie2nie3nie5nie10"));
    assertEquals(20, cal.add("//[nie]\n0nie10nie1nie3nie6"));
  }


  @Test
  public void shouldReturnSumWhen2LongDefinedDelimiters() {
    assertEquals(24, cal.add("//[nie][%%]\n4nie2%%3nie5nie10"));
    assertEquals(21, cal.add("//[nie][%%]\n1nie10%%1nie3nie6"));
    assertEquals(21, cal.add("//[nie][dor]\n1nie10dor1nie3nie6"));
    assertEquals(21, cal.add("//[nie][$#@$]\n1nie10$#@$1nie3nie6"));
    assertEquals(21, cal.add("//[nie][$]\n1nie10$1nie3nie6"));
  }
}

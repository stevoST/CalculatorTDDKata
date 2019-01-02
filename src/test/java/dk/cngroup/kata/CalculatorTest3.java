package dk.cngroup.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest3 {

  private Calculator3 cal = new Calculator3();

  @Test
  public void shuoldReturn0WhenDefault(){
    assertEquals(0, cal.add(""));
  }

  @Test

  public void shuoldReturnNumberWhen1Number(){
    assertEquals(4, cal.add("4"));
    assertEquals(30, cal.add("30"));
  }

  @Test
  public void shuoldReturnSumWhen2Number(){
    assertEquals(9, cal.add("4,5"));
    assertEquals(90, cal.add("30,60"));
  }

  @Test
  public void shuoldReturnSumWhenLotNumbers(){
    assertEquals(19, cal.add("0,4,5,10"));
    assertEquals(99, cal.add("30,60,4,5"));
  }

  @Test
  public void shuoldReturnSumWhen2Delimiters(){
    assertEquals(19, cal.add("0,4\n5,10"));
    assertEquals(99, cal.add("30\n60,4,5"));
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void shuoldFailSumWhen2DelimitersInRow() throws Exception{
    expectedEx.expect(RuntimeException.class);
    expectedEx.expectMessage("nemooozes");
    cal.add("0\n,4,5,10");
    //assertEquals(0, cal.add("0\n,4,5,10"));
    //assertEquals(0, cal.add("30,\n60,4,5"));
  }

  @Test
  public void shuoldReturnSumWhenDefinedDelimiter(){
    assertEquals(19, cal.add("//;\n0;4;5;10"));
    assertEquals(99, cal.add("//;\n30;60;4;5"));
  }

}

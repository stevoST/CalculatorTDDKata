package dk.cngroup.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest8 {

  private Calculator8 cal = new Calculator8();

  @Test
  public void shouldReturn0WhenDefault() {
    assertEquals(0, cal.add(""));
  }

  @Test
  public void shouldReturnNumberWhen1Number() {
    assertEquals(2, cal.add("2"));
    assertEquals(5, cal.add("5"));
  }

  @Test
  public void shouldReturnSumWhen2Numbers() {
    assertEquals(13, cal.add("2,11"));
    assertEquals(5, cal.add("5,0"));
  }

  @Test
  public void shouldReturnSumWhenLotNumbers() {
    assertEquals(35, cal.add("2,11,5,9,7,1"));
    assertEquals(72, cal.add("5,0,55,1,3,8"));
  }

  @Test
  public void shouldReturnSumWhen2Delimiters() {
    assertEquals(35, cal.add("2,11\n5,9\n7,1"));
    assertEquals(72, cal.add("5,0,55,1\n3,8"));
  }

  @Rule
  public ExpectedException excep = ExpectedException.none();

  @Test
  public void shouldFailWhen2DelimitersInARow() {
    excep.expect(RuntimeException.class);
    excep.expectMessage("2 Delimiters in a row");
    cal.add("5,0,55,1\n,3,8");
  }

  @Test
  public void shouldReturnSumWhenDefinedDelimiter() {
    assertEquals(35, cal.add("//;\n2;11\n5,9\n7,1"));
    assertEquals(72, cal.add("//:\n5:0:55:1\n3,8"));
  }

  @Test
  public void shouldFailWhenNegatgiveNumbers() {
    excep.expect(RuntimeException.class);
    excep.expectMessage("Negatives are not allowed [-5, -55, -8]");
    cal.add("-5,0,-55,1\n3,-8");
  }

  @Test
  public void shouldIgnoreNumbersOver1000AndReutrnSum() {
    assertEquals(35, cal.add("//;\n2;1001;11\n5,9\n7,1"));
    assertEquals(1072, cal.add("//;\n5;0,1000,55;1\n3,8"));
  }

  @Test
  public void shouldReutrnSumWhenLongDelimiter() {
    assertEquals(35, cal.add("2***11***5***9***7***1"));
    assertEquals(72, cal.add("5***0***55***1***3***8"));
  }

  @Test
  public void shouldReutrnSumWhenLongDelimiter2() {
    assertEquals(35, cal.add("2the11the5the9the7the1"));
    assertEquals(72, cal.add("5the0the55the1the3the8"));
  }
}

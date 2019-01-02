/*
 * Copyright (c) 2018. FOCUS Online Group GmbH. All rights reserved.
 */

package dk.cngroup.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {


  private Calculator cal = new Calculator();

  @Test
  public void shouldReturn0WhenByDefault() {
    assertEquals(0,cal.add(""));
  }

  @Test
  public void shouldReturnIntWhenStrLen1() {
    assertEquals(2, cal.add("2"));
    assertEquals(5, cal.add("5"));
  }

  @Test
  public void shouldReturnSumWhenStrLen2() {
    assertEquals(7,cal.add("2,5"));
    assertEquals(8,cal.add("1,7"));
  }

  @Test
  public void shouldReturnSumWhenStrLenRand() {
    assertEquals(19,cal.add("2,5,6,4,2"));
    assertEquals(12,cal.add("1,7,4"));
  }

  @Test
  public void shouldReturnSumWhenDiffDelemiters() {
    assertEquals(19,cal.add("2,5/n6,4,2"));
    assertEquals(12,cal.add("1,7/n4"));
  }

  @Test
  public void shouldReturnSumWhenDefineDelemiters() {
    assertEquals(8,cal.add("//;/n1;3;4"));
    assertEquals(8,cal.add("//'/n1'3'4"));
  }
}


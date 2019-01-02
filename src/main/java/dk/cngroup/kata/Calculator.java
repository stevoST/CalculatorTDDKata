/*
 * Copyright (c) 2018. Cn Group. All rights reserved.
 */

package dk.cngroup.kata;

public class Calculator {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.startsWith("//")) {
      String delimiter = "" + numbers.charAt(2);
      numbers = numbers.substring(5);
      String[] numArray = numbers.split(delimiter);
      int sum = 0;
      for (int i = 0; i < numArray.length; i++) {
        sum += Integer.parseInt(numArray[i]);
      }
      return sum;
    } else {
      String[] numArray = numbers.split(",|/n");
      int sum = 0;
      for (int i = 0; i < numArray.length; i++) {
        sum += Integer.parseInt(numArray[i]);
      }
      return sum;
    }

  }
}
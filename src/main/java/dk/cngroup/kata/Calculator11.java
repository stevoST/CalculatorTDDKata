package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator11 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException11("2 delimiters in a row");
    } else if (numbers.startsWith("//")) {
      numbers = numbers.replace(numbers.charAt(2), ',');
      numbers = numbers.substring(4, numbers.length());
    }
    String delimiter = "[,\n]";
    String[] numArray = numbers.split(delimiter);
    int sum = 0;
    for (int i = 0; i < numArray.length; i++) {
      if (Integer.parseInt(numArray[i]) < 0) {
        List<String> negNumList = new ArrayList<>();
        negNumList.add(numArray[i]);
        i++;

        for (int j = i; j < numArray.length; j++) {
          if (Integer.parseInt(numArray[j]) < 0) {
            negNumList.add(numArray[j]);
          }
        }
        throw new MyNewException11("negatives are not allowed " + negNumList);
      }
      if (Integer.parseInt(numArray[i]) <= 1000) {
        sum += Integer.parseInt(numArray[i]);
      }
    }
    return sum;
  }
}

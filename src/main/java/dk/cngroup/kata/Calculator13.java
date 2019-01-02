package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator13 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException13("2 Delimiters in a row");
    } else if (numbers.startsWith("//[")) {
      int i = 0;
      //while(numbers.indexOf("]")+1<numbers.indexOf("\n")) {
        numbers = numbers.substring(3, numbers.length());
      while(numbers.contains("]\n")) {
        numbers = numbers.replace(numbers.substring(0, numbers.indexOf("]")), ',' + "");
        numbers = numbers.substring(3, numbers.length());
      }
    } else if (numbers.startsWith("//")) {
      numbers = numbers.replace(numbers.charAt(2), ',').substring(4, numbers.length());
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
        throw new MyNewException13("Negatives are not allowed " + negNumList);
      }
      if (Integer.parseInt(numArray[i]) <= 1000) {
        sum += Integer.parseInt(numArray[i]);
      }
    }
    return sum;
  }

}

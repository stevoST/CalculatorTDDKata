package dk.cngroup.kata;


import java.util.ArrayList;
import java.util.List;

public class Calculator4 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException4("Incorrect delimiters");
    }

    String delimiter = "[,\n]";
    if (numbers.startsWith("//")) {
      delimiter = delimiter.substring(0, 2) + numbers.charAt(2) + delimiter
          .substring(2, delimiter.length());
      numbers = numbers.substring(4);
    }

    int sum = 0;
    String[] numArray = numbers.split(delimiter + "");

    for (int i = 0; i < numArray.length; i++) {
      List<String> negNumbers = new ArrayList<>();
      if (Integer.parseInt(numArray[i]) < 0) {
        for (int j = i; j < numArray.length; j++) {
          if (Integer.parseInt(numArray[j]) < 0) {
            negNumbers.add(numArray[j]);
          }
        }
      throw new MyNewException4("negatives not allowed " + negNumbers);
    }
      sum += Integer.parseInt(numArray[i]);
    }
   return sum;
  }

}

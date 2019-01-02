package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator9 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException9("2 Delimiters in a row");
    }

    String delimiter = "[,\n]";
    String delimiter2 = "";
    String delimiter3 ="";
    int delimBreakCharIndex = 0;
    if (numbers.startsWith("//")) {
      delimBreakCharIndex = numbers.indexOf("]");
      if (delimBreakCharIndex == -1) {
        delimiter = delimiter.substring(0, 2) + numbers.charAt(2) + delimiter
            .substring(2, delimiter.length());
        numbers = numbers.replace(numbers.charAt(2)+"", ",");
        numbers = numbers.substring(numbers.indexOf("\n") + 1, numbers.length());
      } else if (delimBreakCharIndex > 3) {
        delimiter2 = numbers.substring(numbers.indexOf("[")+1, delimBreakCharIndex);
        numbers = numbers.replace(delimiter2, ",");
        numbers = numbers.substring(delimBreakCharIndex, numbers.length());
        delimBreakCharIndex = numbers.indexOf("]");
        if(delimBreakCharIndex>0){
          delimiter3 = numbers.substring(0, delimBreakCharIndex);
          numbers = numbers.replace(delimiter3, ",");
          numbers = numbers.substring(3, numbers.length());
        }
      }


    }
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
        throw new MyNewException9("Negatives are not allowed " + negNumList);
      }
      if (Integer.parseInt(numArray[i]) <= 1000) {
        sum += Integer.parseInt(numArray[i]);
      }
    }
    return sum;
  }
}

package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator5 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException5("Delimiter issue");
    }
    String delimiter = "[,\n]";
    if(numbers.startsWith("//")){
      delimiter = delimiter.substring(0,2)+numbers.charAt(2)+delimiter.substring(2,delimiter.length());
      numbers = numbers.substring(4);
    }
    String[] numArray = numbers.split(delimiter);
    int sum = 0;
    for (int i = 0; i < numArray.length; i++) {
      if (Integer.parseInt(numArray[i])<0) {
        List<String> negNumbersList = new ArrayList<>();
        for(int j =i;j<numArray.length;j++){
          if (Integer.parseInt(numArray[j])<0) {
            negNumbersList.add(numArray[j]);
          }
        }
        throw new MyNewException5("negatives not allowed" + negNumbersList);
      }
      sum += Integer.parseInt(numArray[i]);
    }
    return sum;
  }
}

package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator6 {

  public int add(String numbers){
    if(numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException6("2 Delimiters in a row");
    }
    String delimiter = "[,\n]";
    if(numbers.startsWith("//")){
      delimiter = delimiter.substring(0,3) + numbers.charAt(2) + delimiter.substring(3,delimiter.length());
      numbers = numbers.substring(4,numbers.length());
    }
    String[] numArray = numbers.split(delimiter);
    int sum =0;
    for(int i = 0; i<numArray.length; i++){
      if(Integer.parseInt(numArray[i])<0){
        List<String> negList = new ArrayList<>();
        for (int j = i; j<numArray.length; j++){
          if(Integer.parseInt(numArray[j])<0) {
            negList.add(numArray[j]);
          }
        }
        throw new MyNewException6("negatives are not allowed " + negList);
      }
      sum += Integer.parseInt(numArray[i]);
    }
    return sum;
  }
}

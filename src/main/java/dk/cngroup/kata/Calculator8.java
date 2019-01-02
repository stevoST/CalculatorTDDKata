package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator8 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if(numbers.contains("\n,") || numbers.contains(",\n")){
      throw new MyNewException8("2 Delimiters in a row");
    }

    String delimiter = "[,\n]";

    if(numbers.startsWith("//")){
      delimiter = delimiter.substring(0,2) + numbers.charAt(2) + delimiter.substring(2,delimiter.length());
      numbers = numbers.substring(4,numbers.length());
    }

    String[] numArray = numbers.split(delimiter);
    int sum = 0;

    for (int i = 0; i < numArray.length; i++) {
      if(Integer.parseInt(numArray[i])<0){
        List<String> negNumList = new ArrayList<>();
        negNumList.add(numArray[i]);
        i++;

        for(int j = i; j<numArray.length;j++){
          if(Integer.parseInt(numArray[j])<0){
            negNumList.add(numArray[j]);
          }
        }

        throw new MyNewException8("Negatives are not allowed " + negNumList);
      }
      if(Integer.parseInt(numArray[i])<=1000){sum += Integer.parseInt(numArray[i]);}
    }

    return sum;
  }

}

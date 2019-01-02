package dk.cngroup.kata;

import java.util.ArrayList;
import java.util.List;

public class Calculator12 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")){
      throw new MyNewException12("2 delimiters in a row");
    } else if(numbers.startsWith("//")){
      numbers = numbers.replace(numbers.charAt(2),',').substring(4,numbers.length());
    }

    String delimiter = "[,\n]";
    String[] numarray = numbers.split(delimiter);

    int sum = 0;
    for (int i = 0; i < numarray.length; i++) {
      if(Integer.parseInt(numarray[i])<0){
        List<String> negNumList = new ArrayList<>();
        negNumList.add(numarray[i]);
        i++;

        for(int j = i;j<numarray.length;j++){
          if(Integer.parseInt(numarray[j])<0) {
            negNumList.add(numarray[j]);
          }
        }
        throw new MyNewException12("negatives are not allowed "+negNumList);
      }
      sum += Integer.parseInt(numarray[i]);
    }
    return sum;
  }
}

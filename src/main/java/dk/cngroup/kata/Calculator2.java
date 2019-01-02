package dk.cngroup.kata;

public class Calculator2 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains(",\n") || numbers.contains("\n,")) {
      return 0;
    }
    int sum = 0;
    if(numbers.startsWith("//")){
      char delimiter = numbers.charAt(2);
      String subNumbers = numbers.substring(4);
      String[] pice = subNumbers.split(delimiter+"");
      for (int i = 0; i < pice.length; i++) {
        sum += Integer.parseInt(pice[i]);
      }
      return sum;
    }
    String[] numArray = numbers.split("[,\n]");
    for (int i = 0; i < numArray.length; i++) {
      sum += Integer.parseInt(numArray[i]);
    }
    return sum;

  }
}

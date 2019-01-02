package dk.cngroup.kata;

public class Calculator3 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      throw new MyNewException3("nemooozes");
      //return 0;
    } else if(numbers.startsWith("//")){
      char delimiter = numbers.charAt(2);
      numbers = numbers.substring(4);
      String[] numArray = numbers.split(delimiter+"");
      int sum = 0;
      for (int i = 0; i < numArray.length; i++) {
        sum += Integer.parseInt(numArray[i]);
      }
      return sum;
    }
    int sum = 0;
    String delimiters = "[,\n]";
    String[] numArray = numbers.split(delimiters);
    for (int i = 0; i < numArray.length; i++) {
      sum += Integer.parseInt(numArray[i]);
    }
    return sum;
  }
}

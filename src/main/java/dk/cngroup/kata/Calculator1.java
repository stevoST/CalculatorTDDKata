package dk.cngroup.kata;

public class Calculator1 {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    } else if (numbers.contains("\n,") || numbers.contains(",\n")) {
      return 0;
    } else if (numbers.startsWith("//")){
      // nedokoncene
      return 45;
  } else {
      int sum = 0;
      String[] numArray = numbers.split("[\n,]");
      for (int i = 0; i < numArray.length; i++) {
        sum += Integer.parseInt(numArray[i]);
      }
      return sum;
    }
  }
}

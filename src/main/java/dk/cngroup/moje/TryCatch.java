package dk.cngroup.moje;

public class TryCatch {

  public static void main(String [] args){
    int i = 12;
    int j = 0;

    try {
      System.out.println(i / j);
    } catch(Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }

}

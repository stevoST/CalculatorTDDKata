package dk.cngroup.kata;

//https://stackoverflow.com/questions/1070590/how-can-i-write-custom-exceptions
public class MyNewException3 extends RuntimeException {

  public MyNewException3(){
    super();
  }

  public MyNewException3(String message){
    super(message);
  }
}
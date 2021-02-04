import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int instances = scnr.nextInt();
    scnr.nextLine(); // move past line break
    for (int i = 0; i < instances; i++) {
      String output = scnr.nextLine().strip(); // read next line and strip whitespace
      System.out.println("Hello, " + output + "!");
    }
    
    scnr.close();
  }
}
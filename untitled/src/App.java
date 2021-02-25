import java.util.Arrays;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int numInstances = scnr.nextInt();
    scnr.nextLine();
    
    for (int i = 0; i < numInstances; i++) {
      int numPages = scnr.nextInt();
      scnr.nextLine();
      int numRequests = scnr.nextInt();
      scnr.nextLine();
      
      int[] requestSchedule = Arrays.stream(scnr.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      
      System.out.println(Arrays.toString(requestSchedule));
      System.out.println(numPages);
    }
    
    scnr.close();
  }
}
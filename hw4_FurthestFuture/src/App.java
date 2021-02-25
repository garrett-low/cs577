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
      
      int[] requestSchedule = new int[numRequests];
      
      for (int j = 0; j < numRequests; j++) {
        requestSchedule[j] = scnr.nextInt();
        scnr.next();
      }
      
      System.out.println(requestSchedule);
      System.out.println(numPages);
    }
    
    scnr.close();
  }
}
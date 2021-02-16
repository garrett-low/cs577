import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scnr = new Scanner(System.in);
    int numSchedules = scnr.nextInt();
    scnr.nextLine();

    for (int i = 0; i < numSchedules; i++) {
      List<Job> jobList = new ArrayList<>();
      int numJobs = scnr.nextInt();
      scnr.nextLine();

      for (int j = 0; j < numJobs; j++) {
        // int[] startEndTime = new int[2];
        // String startEndString = scnr.nextLine();
        // startEndTime = Arrays.stream(startEndString.split(" ")).mapToInt(Integer::parseInt).toArray();
        // jobList.add(startEndTime);
        int startTime = scnr.nextInt();
        int endTime = scnr.nextInt();
        scnr.nextLine();
        Job newJob = new Job(startTime, endTime);
        jobList.add(newJob);
      }         
      
      // System.out.println(jobList);
      System.out.println(FinishFirst(jobList));
    }
    
    scnr.close();
  }
  
  public static int FinishFirst(List<Job> jobList) {
    int numJobsScheduled = 0;
    
    if (jobList == null) {
      return numJobsScheduled;
    }
    
    Collections.sort(jobList);
    
    int currJobEndTime = 0;
    for (int i = 0; i < jobList.size(); i++) {
      if (currJobEndTime <= jobList.get(i).getStartTime()) {
        numJobsScheduled++;
        currJobEndTime = jobList.get(i).getEndTime();
      }
    }
    
    return numJobsScheduled;
  }
}
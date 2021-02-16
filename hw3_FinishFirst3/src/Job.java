public class Job implements Comparable<Job> {
  private int startTime;
  private int endTime;

  public Job(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  public int getEndTime() {
    return endTime;
  }

  @Override
  public int compareTo(Job otherJob) {
    return Integer.compare(this.getEndTime(), otherJob.getEndTime());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    
    if (!(o instanceof Job)) {
      return false;
    }
    
    Job otherJob = (Job) o;
    
    return (this.getStartTime() == otherJob.getStartTime()) && (this.getEndTime() == otherJob.getEndTime());
  }
  
  @Override
  public String toString() {
    return "startTime: " + this.getStartTime() + ", endTime: " + this.getEndTime();
  }
}
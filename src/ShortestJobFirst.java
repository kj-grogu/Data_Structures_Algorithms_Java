import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestJobFirst {

  private static class Job {
    private int id, arrivalTime, burst;

    private int completionTime, waitTime, turnAroundTime;

    public Job(int ii, int arvT, int burstT) {
      id = ii;
      arrivalTime = arvT;
      burst = burstT;
    }

    public void computeWaitAndTurnAround(int ct) {
      completionTime = ct;
      turnAroundTime = completionTime - arrivalTime;
      waitTime = turnAroundTime - burst;
    }

    @Override
    public String toString() {
      return "id: " + (this.id + 1 )+ ", AT : "  +this.arrivalTime + ", BT : " + this.burst + ", CT : " + this.completionTime + ", TT : " + this.turnAroundTime + ", WT : " + this.waitTime;
    }

  }

  public static void main(String[] args) {
    int[] processBurst = new int[]{7, 4, 1, 4};
    int[] processArrivalTime = new int[]{0, 2, 4, 5};
//
//    int[] processBurst = new int[]{7, 1};
//    int[] processArrivalTime = new int[]{2, 5};


//    int[] processBurst = new int[]{7};
//    int[] processArrivalTime = new int[]{5};


    int N = processBurst.length;

    Job[] jobs = new Job[N];
    for (int i = 0; i < N; i++) {
      jobs[i] = new Job(i, processArrivalTime[i], processBurst[i]);
    }

    PriorityQueue<Job> minHeap = new PriorityQueue<>(new Comparator<Job>() {
      @Override
      public int compare(Job o1, Job o2) {
        if (o1.burst == o2.burst) // if burst are same, pick the job that arrived first
          return o1.arrivalTime - o2.arrivalTime;

        return o1.burst - o2.burst;
      }
    });


    minHeap.offer(jobs[0]); // offer the first job into the minHeap
    int clockTime = jobs[0].arrivalTime; // start the clock from the arrival of the first job
    int i = 1;

    List<Integer> completionOrder = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      Job finishedJob = minHeap.poll();
      completionOrder.add(finishedJob.id);
      clockTime += finishedJob.burst;
      finishedJob.computeWaitAndTurnAround(clockTime);

      // add all the jobs into the minHeap that have arrived untill Now (endT)
      while (i < N && jobs[i].arrivalTime <= clockTime) {
        minHeap.offer(jobs[i]);
        i++;
      }
    }

    System.out.println("completionOrder : " + completionOrder);
    for (int idx : completionOrder) {
      System.out.println(jobs[idx]);
    }
  }
}
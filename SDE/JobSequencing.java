import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencing {

    public static void main(String[] args) {
        int[][] inp = {{1,2,100},{2,1,19},{3,2,27},{4,1,25},{5,1,15}};
        int n = 5;
        Job[] arr = new Job[n];
        for (int i= 0 ; i < n ; i ++){
            arr[i] = new Job(inp[i][0], inp[i][1], inp[i][2]);
        }
        JSeq sol = new JSeq();
        int[] res  = sol.JobScheduling(arr, n);
        System.out.printf("jobs = %d  and profile = %d" , res[0], res[1]);
    }
    
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }

    @Override
    public String toString(){
        return "[ " + id + " " + deadline + " " + profit + " ]";
    }
}

class JSeq
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n){

        Comparator<Job> comp = new Comparator<Job>() {
         public int compare(Job j1, Job j2){
            if (j1.deadline == j2.deadline && j1.profit == j2.profit){
                return Integer.compare(j1.id, j2.id);
            }
            if (j1.deadline == j2.deadline){
                return Integer.compare(j2.profit, j1.profit);
            }else{
                return Integer.compare(j2.deadline, j1.deadline);
            }
         }   
        };
        PriorityQueue<Job> maxheap = new PriorityQueue<>(n,comp);
        for (Job j: arr){
            maxheap.add(j);
        }
        
        int max_jobs_possible = maxheap.peek().deadline;
        int count = 0;
        int profit = 0;
        int last_deadline = Integer.MAX_VALUE;
        int deadline_reduction = 1;
        while(count < max_jobs_possible && maxheap.peek().deadline > 0){
            Job nextJob = maxheap.poll();
            if (nextJob.deadline < last_deadline){
                profit += nextJob.profit;
                count ++;
                last_deadline = nextJob.deadline;
                deadline_reduction = 1;
            }else{
                nextJob.deadline -= deadline_reduction;
                deadline_reduction += 1;
                maxheap.add(nextJob);
            }
        }
        return new int[]{count, profit};

    }
}
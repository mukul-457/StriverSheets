import java.util.PriorityQueue;

public class HeapKthLargestElement {
    public static void main(String[] args) {
        System.out.println(KL.findKthLargest(new int[]{3}, 1));
    }
}


class KL {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : nums){
            pq.add((Integer) ele);
        }
        k = nums.length-k+1;
        int ans=0;
        while(k >0){
            ans = (int) pq.poll();
            k--;
        }
        return ans;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals  = new int[][]{{1,4},{4,5}};
        MergeI sol = new MergeI();
        int[][] merged  = sol.merge(intervals);
        System.out.println(Arrays.deepToString(merged));
    }   
}

class MergeI{
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>() ;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > end){
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1]; 
            }else{
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}

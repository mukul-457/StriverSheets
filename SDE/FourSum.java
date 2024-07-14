import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] inp = new int[]{-3,-2,-1,0,0,1,2,3};
        FS fs = new FS();
        System.out.println(fs.fourSum(inp, 0));

    }
}

class FS {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<int[]>> sums = new HashMap<>();
        Set<List<Integer>> setOfLists = new HashSet<>();
        Arrays.sort(nums);
        for (int p1 = 0 ; p1 < nums.length; p1++){
            for (int p2 = p1+1; p2< nums.length; p2++ ){
                int required_sum = target-nums[p1]-nums[p2];
                if (sums.containsKey(required_sum)){
                    List<int[]> validOpts = getValid(p1, p2, sums.get(required_sum));
                    for(int[] opt : validOpts){
                        List<Integer> curr_sol = new ArrayList<>(
                            Arrays.asList(nums[p1],nums[p2], nums[opt[0]], nums[opt[1]])
                        );
                        curr_sol.sort(null);
                        setOfLists.add(curr_sol);                        
                    }
                }
                if (sums.containsKey(nums[p1] + nums[p2])){
                    List<int[]> summing_ele = sums.get(nums[p1] + nums[p2]);
                    summing_ele.add(new int[]{p1,p2});
                    sums.put(nums[p1]+nums[p2], summing_ele);
                }else{
                sums.put(nums[p1] + nums[p2], new ArrayList<>(Arrays.asList(new int[]{p1, p2})));
                }
                
            }
        }
        return new ArrayList<>(setOfLists);
    }

    public List<int[]> getValid(int p1 , int p2 , List<int[]> options ){
        List<int[]> validOptions = new ArrayList<>();
        for (int[] option : options){
            if (isValid(p1, p2, option)){
                validOptions.add(option);
            }
        }
        return validOptions;
    }

    public boolean isValid(int p1, int p2, int[] p34){
        if (p1 != p34[0] && p1 != p34[1] && p2 != p34[0] && p2 != p34[1]){
            return true;
        }
        return false;
    }

}


public class TrappingRainWater {
    public static void main(String[] args) {
        int[] inp = new int[]{0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};
        TRW trw = new TRW();
        System.out.println(trw.trap(inp)); 
    }
}

class TRW {
    public int trap(int[] height) {
        int left_wall_height = 0;
        int i = 0;
        int j = height.length-1;
        int right_wall_height = 0;        
        int water = 0;

        while (i <= j){
            if (height[i] <= height[j]){
                water += Math.max( 0,  left_wall_height- height[i]);
                left_wall_height = Math.max(left_wall_height, height[i]);
                i ++;
            }
            else{
                water += Math.max(0, right_wall_height - height[j]);
                right_wall_height = Math.max(right_wall_height,height[j]);
                j --;
            }
        }
        return water;
    }
}
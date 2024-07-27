import java.util.Arrays;

public class Nmeetings {
    
}

class NM 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int[][] meetings  =  new int[n][2];
        for (int i = 0; i < n ; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a,b)->{
            return Integer.compare(a[1], b[1]);
        });
        int count  = 0;
        int lastEnd = meetings[0][1];
        for(int i = 1; i < n; i++){
            if (meetings[i][0] > lastEnd){
                count ++;
                lastEnd = meetings[i][1];
            }
        }

        return count;


    }
}

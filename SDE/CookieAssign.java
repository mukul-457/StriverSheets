import java.util.Arrays;
public class CookieAssign {
    
}

class CA {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child_index = 0;
        int cookie_index = 0;
        while (cookie_index < s.length && child_index < g.length){
            if (g[child_index] <= s[cookie_index]){
                child_index ++;
            }
            cookie_index ++;
        }
        
        return child_index;
    }
}
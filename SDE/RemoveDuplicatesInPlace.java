public class RemoveDuplicatesInPlace {
    
}

class RDIP {
    public int removeDuplicates(int[] num) {
        int i=0;
        for(int j=1;j<num.length;j++){
            if(num[i]!=num[j] ){
                i++;
                num[i]=num[j];
            }
        }
        return i+1;
        
    }
}
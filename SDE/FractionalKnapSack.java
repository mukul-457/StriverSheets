import java.util.Arrays;
import java.util.Comparator;


public class FractionalKnapSack {
    public static void main(String[] args) {
        Item[] arr = new Item[3];
        arr[0] = new Item(60, 10);
        arr[1] = new Item(100, 20);
        arr[2] = new Item(120, 30);

        FKS  sol = new FKS();
        System.out.println(sol.fractionalKnapsack(50, arr, 3));
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }

    public String toString(){
        return "[ " + value + ", " + weight + " ]"; 
    }
} 

class FKS {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {

        Comparator<Item> comp = new Comparator<Item>() {
            public int compare(Item i1 , Item i2){
                return Double.compare((double)i2.value / (double)i2.weight, (double)i1.value / (double)i1.weight );
            }
        };

        Arrays.sort(arr, comp);
        double value = 0;
        for(Item it: arr){
            if (w <=0 ){
                break;
            }
            int considered_weight = Math.min(w, it.weight);
            value  += ((double)it.value / (double) it.weight) * considered_weight;
            w -= considered_weight;
        }
        return value;
    }
}
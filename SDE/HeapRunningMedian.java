import java.util.PriorityQueue;

public class HeapRunningMedian {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}

// class MedianFinder {
//     PriorityQueue<Integer> maxHeap ;
//     PriorityQueue<Integer> minHeap;
//     int maxHeapSize;
//     int minHeapSize;
//     public MedianFinder() {
//         maxHeap = new PriorityQueue<>();
//         maxHeap.add(Integer.MAX_VALUE);
//         minHeap = new PriorityQueue<>();
//         minHeap.add(Integer.MAX_VALUE);
//         maxHeapSize = 0;
//         minHeapSize = 0;        
//     }
    
//     public void addNum(int num) {
//         if (maxHeapSize < minHeapSize){
//             if (minHeap.peek() < num){
//                 maxHeap.add(minHeap.poll()*-1);
//                 minHeap.add(num);
//             }else{
//                 maxHeap.add(num*-1);
//             }
//             maxHeapSize++;
//         }else{
//             if (maxHeap.peek()*-1 > num){
//                 minHeap.add(maxHeap.poll()*-1);
//                 maxHeap.add(num*-1);
//             }else{
//                 minHeap.add(num);
//             }
//             minHeapSize++;
//         }
//     }
    
//     public double findMedian() {
//         if (maxHeapSize == minHeapSize){
//             return (maxHeap.peek()*-1 + minHeap.peek()) / (double) 2;
//         }else{
//             return (double) minHeap.peek();
//         }
//     }
// }

class MedianFinder {
    int[] hashVals;
    int median;
    int medianCount2x;

    public MedianFinder() {
        hashVals = new int[200001];
        median = Integer.MIN_VALUE;
        medianCount2x = 1;
    }
    
    public void addNum(int num) {
        hashVals[num+100000]++;
        if (median != Integer.MIN_VALUE) {
            if (num > median) {
                if (medianCount2x < 2*hashVals[median+100000]) {
                    medianCount2x++;
                } else {
                    medianCount2x = 1;
                    while (hashVals[++median+100000] == 0) {}
                }
            } else if (num < median) {
                if (medianCount2x > 1) {
                    medianCount2x--;
                } else {
                    while (hashVals[--median + 100000] ==0) {}
                    medianCount2x = 2*hashVals[median+100000];
                }
            } else {
                medianCount2x++;
            }
        } else {
            median = num;
        }
    }
    
    public double findMedian() {
        if (medianCount2x % 2 == 0) {
            if (2*hashVals[median+100000] > medianCount2x) {
                return median;
            } else {
                int median2 = median;
                while (hashVals[++median2 + 100000] == 0) {}
                return (median + median2)/2.0;
            }
        } else {
            return median;
        }
    }
}
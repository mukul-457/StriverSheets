public class BuyAndSellStock {
    
}
class BSS {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int buy  = prices[0];
        for(int index = 1; index < prices.length; index++){
            buy = Math.min(buy, prices[index]);
            maxp = Math.max(maxp , prices[index]- buy);
        }
        return maxp;
    }
}

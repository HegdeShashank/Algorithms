import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {

    /***
     * Find maximum revenue from bottom-up approach of dynamic programming.
     * @param prices - the revenue earned by the company when the rod cut into the length of inch i.
     * @return - maximum revenue that can be generated.
     */
    static RodCuttingRevenue findCuttingWaysToGetMaximumRevenue(int[] prices, int priceToCut) {
        int len = prices.length;
        int[] optimalCuts = new int[len+1];
        int[] revenue = new int[len+1];
        for(int i=1; i<=len; i++) {
            int max = prices[i-1];
            optimalCuts[i] = i;
            for(int j=0;j<i; j++) {
                int price = prices[j] + revenue[i-j-1] - priceToCut;
                if(max<price) {
                    max = price;
                    optimalCuts[i] = j+1;
                }
            }
            revenue[i] = max;
        }
        return new RodCuttingRevenue(revenue[len], optimalCuts);
    }

    static List<Integer> findOptimalCutLength(int[] revenue) {
        int len = revenue.length-1;
        List<Integer> optimalCuts = new ArrayList<>();
        while (len>0) {
            optimalCuts.add(revenue[len]);
            len = len-revenue[len];
        }
        return optimalCuts;
    }

    static RodCuttingRevenue memoizedCutRod(int[] prices) {
        int len = prices.length;
        int[] revenue = new int[len+1];
        int[] optimalCuts = new int[len+1];
        return new RodCuttingRevenue(
                memoizedCutRodAux(prices, revenue, len, optimalCuts),
                optimalCuts
        );
    }

    static int memoizedCutRodAux(int[] prices, int[] revenue, int n, int[] optimalCuts) {
        int maxRevenue;
        if(revenue[n]>0) {
            return revenue[n];
        }
        if(n==0)
            return 0;
        else {
            maxRevenue = prices[n-1];
            optimalCuts[n] = n;
            for (int i=0;i<n;i++) {
                int currentRevenue = prices[i] + memoizedCutRodAux(prices, revenue, n-i-1, optimalCuts);
                if(maxRevenue < currentRevenue) {
                    maxRevenue = currentRevenue;
                    optimalCuts[n] = i+1;
                }
            }
        }
        System.out.println("n:"+n+" max revenue:"+maxRevenue);
        revenue[n] = maxRevenue;
        return maxRevenue;
    }

    public static void main(String[] args) {
        int[] prices = {2,5,10,9,10,22,17,20,24,7};
        RodCuttingRevenue cuts = findCuttingWaysToGetMaximumRevenue(prices,0);
        int max = cuts.maxRevenue;
        System.out.println("Maximum revenue: "+max+ " ");
        for (int i=0;i<cuts.optimalCuts.length;i++) {
            System.out.print(cuts.optimalCuts[i]+" ");
        }
        List<Integer> a = findOptimalCutLength(cuts.optimalCuts);
        System.out.println(a);
        System.out.println(memoizedCutRod(prices).maxRevenue);
        System.out.println(Arrays.toString(memoizedCutRod(prices).optimalCuts));
    }
}

class RodCuttingRevenue {
    int maxRevenue;
    int[] optimalCuts;
    RodCuttingRevenue(int maxRevenue, int[] optimalCuts) {
        this.maxRevenue = maxRevenue;
        this.optimalCuts = optimalCuts;
    }
}
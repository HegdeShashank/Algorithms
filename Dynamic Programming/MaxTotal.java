public class MaxTotal {
    static void maximizeSum(int []arr, int K, int n) {
        int ans = maximizeSumUtil(arr, 0, n - 1, K);
        int ans2 = maximizeSumUtilDp(arr, K, n);
        System.out.println(ans);
        System.out.println(ans2);
    }

    static int maximizeSumUtil(int []arr, int start, int end, int k) {
        if(k == 1) return Math.max(arr[start], arr[end]);
        return Math.max(
                arr[start] + maximizeSumUtil(arr, start + 1, end, k - 1),
                arr[end] + maximizeSumUtil(arr, start, end - 1, k - 1)
        );
    }

    static int maximizeSumUtilDp(int []arr, int k, int n) {
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = 0;
        for(int i = 1; i < n; i++) {
            leftSum[i] = arr[i - 1] + leftSum[i - 1];
        }
        rightSum[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            rightSum[i] = arr[i + 1] + rightSum[i + 1];
        }
        // [ 1, 2, 3, 4, 5]
        // [0, 1, 3, 6, 10]

        int max = 0;
        for(int i = 0; i <= k; i++) {
            max = Math.max(max, leftSum[i] + rightSum[n - i  + 1]);
        }

        return max;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = { 8, 4, 4, 8, 12, 3, 2, 9 };
        int K = 3;
        int n = arr.length;
        maximizeSum(arr, K, n);
    }
}


/***
 *   leftSum[]
 *   rightSum[] =
 *
 *   i = 0, k
 *
 *   k == 3
 *
 *   leftSum(0), rightSum(3)
 *   leftSum(1), rightSum(2)
 *   leftSum(2), rightSum(1)
 *   leftSum(3), rightSum(0)
 *
 *
 */
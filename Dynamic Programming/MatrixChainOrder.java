import java.util.Arrays;

public class MatrixChainOrder {
    static int getMinimumMultiplicationCost(int[] matricesDimension, int[][] order) {
        int totalNumOfMatrix = matricesDimension.length - 1;
        int[][] m = new int[totalNumOfMatrix][totalNumOfMatrix];
        // l is chain length here.
        for(int l=2; l <= totalNumOfMatrix; l++) {
            for(int i=0; i < totalNumOfMatrix-l+1; i++) {
              int j = i+l-1;
              m[i][j] = Integer.MAX_VALUE;
              for(int k=i;k<j;k++) {
                  int min = m[i][k]+m[k+1][j] + matricesDimension[i]*matricesDimension[j+1] * matricesDimension[k+1];
                  if(min < m[i][j]) {
                      m[i][j] = min;
                      order[i][j] = k;
                  }
                  System.out.println("i:"+i+" "+" j:"+j+" k:"+k+ " m:"+m[i][j]);
              }
            }
        }
        System.out.println(Arrays.deepToString(m));
        System.out.println(Arrays.deepToString(order));
        return m[0][totalNumOfMatrix-1];
    }

    static void printOptimalParenthesizedSolution(int[][] order, int i, int j) {
        if(i==j) {
            System.out.print("A"+i+1);
        } else {
            System.out.print("(");
            printOptimalParenthesizedSolution(order, i, order[i][j]);
            printOptimalParenthesizedSolution(order, order[i][j]+1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        // We are assuming here that matrix A[i] has dimension of A[i]*A[i+1].
        int[] matrixDimension = {30,35,15,5,10,20,25};
        int[][] matrixOrder = new int[matrixDimension.length-1][matrixDimension.length-1];
        System.out.println(getMinimumMultiplicationCost(matrixDimension, matrixOrder));
        printOptimalParenthesizedSolution(matrixOrder, 0, matrixDimension.length-2);
    }
}

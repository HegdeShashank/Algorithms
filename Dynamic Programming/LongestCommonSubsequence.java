import java.util.Arrays;

public class LongestCommonSubsequence {

    static String getLongestCommonSubsequence(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        String[][] subsequence = new String[l1+1][l2+1];
        for(int i=0;i<l1+1; i++) {
            Arrays.fill(subsequence[i], "");
        }
        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    subsequence[i][j] =  subsequence[i-1][j-1] + s1.charAt(i-1);
                } else if(subsequence[i-1][j].length()> subsequence[i][j-1].length()) {
                    subsequence[i][j] = subsequence[i-1][j];
                } else {
                    subsequence[i][j] = subsequence[i][j-1];
                }
            }
        }
        return subsequence[l1][l2];
    }

    static String getLongestCommonSubsequenceRecursive(String s1, String s2) {
        return getLongestCommonSubsequenceUtilRecursive(s1, s2,0, 0);
    }

    static String getLongestCommonSubsequenceUtilRecursive(String s1, String s2, int i, int j) {
        if(i>= s1.length() || j>= s2.length()) {
            return "";
        }
        if(s1.charAt(i)== s2.charAt(j)) {
            return s1.charAt(i) + getLongestCommonSubsequenceUtilRecursive(s1, s2, i+1, j+1);
        } else {
            String subsequence1 = getLongestCommonSubsequenceUtilRecursive(s1, s2, i+1, j);
            String subsequence2 = getLongestCommonSubsequenceUtilRecursive(s1, s2, i, j+1);
            return subsequence1.length()> subsequence2.length() ? subsequence1: subsequence2;
        }
    }

    static String getLongestCommonPalindromeSubSequence(String text) {
        return getLongestCommonSubsequence(text, new StringBuilder(text).reverse().toString());
    }

    public static void main(String[] args) {
        String longestCommonSubsequence = getLongestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd");
        String longestCommonSubsequenceRecursive = getLongestCommonSubsequenceRecursive("pmjghexybyrgzczy", "hafcdqbgncrcbihkd");
        String longestCommonPalindromeSubsequence = getLongestCommonPalindromeSubSequence("character");
        System.out.println("Longest subsequence.");
        System.out.println("-------------------------------");
        System.out.println(longestCommonSubsequence + " "+ longestCommonSubsequenceRecursive+"\n");
        System.out.println("Longest palindrome subsequence.");
        System.out.println("-------------------------------");
        System.out.println(longestCommonPalindromeSubsequence);
    }
}

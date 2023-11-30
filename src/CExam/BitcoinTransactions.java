package CExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BitcoinTransactions {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String[] first = scanner.nextLine().split("\\s+");
            String[] second = scanner.nextLine().split("\\s+");


            int[][] dp = new int[first.length + 1][second.length + 1];
            int count = findLongestSub(first, second, dp);


            List<String> longestSubsequence = getLongestSubsequence(first, second, dp);
           StringBuilder builder = new StringBuilder();
           System.out.println(longestSubsequence.toString().replaceAll(",", ""));



        }


        private static int findLongestSub(String[] first, String[] second, int[][] dp) {
            for (int i = 0; i <= first.length; i++) {
                for (int j = 0; j <= second.length; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if (first[i - 1].equals(second[j - 1])) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

            }
            return dp[first.length][second.length];
        }

        private static List<String> getLongestSubsequence (String[]first, String[]second,int[][] dp){
            List<String> subsequence = new ArrayList<>();
            int i = first.length;
            int j = second.length;
            int maxLength = dp[i][j];  // Дължината на най-дългата редица

            // Намиране на първата редица, която започва преди другите
            while (i > 0 && j > 0) {
                if (first[i - 1].equals(second[j - 1]) && dp[i][j] == maxLength) {
                    subsequence.add(first[i - 1]);
                    i--;
                    j--;
                    maxLength--;
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            // Обръщане на редицата, за да получите правилния ред
            List<String> reversedSubsequence = new ArrayList<>();
            for (int k = subsequence.size() - 1; k >= 0; k--) {
                reversedSubsequence.add(subsequence.get(k));
            }

            return reversedSubsequence;
        }
    }



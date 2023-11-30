package GraphTheoryExe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Salaries {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static long[] salaries;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employees = Integer.parseInt(scanner.nextLine());
        visited = new boolean[employees];
        salaries = new long[employees];
        char[][] matrix = new char[employees][];


        for (int row = 0; row < employees; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        int[] managersCount = new int[employees];

        for (int row = 0; row < matrix.length; row++) {
            graph.add(new ArrayList<>());
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'Y') {
                    graph.get(row).add(col);
                    managersCount[col]++;
                }
            }
        }

        List<Integer> sources = new ArrayList<>();

        for (int i = 0; i < managersCount.length; i++) {
            if (managersCount[i] == 0) {
                sources.add(i);
            }
        }

        for (Integer source : sources) {
            dfs(source);
        }

        long sum = Arrays.stream(salaries).sum();
        System.out.println(sum);


    }

    private static void dfs(Integer node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (Integer child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);

                long sum = graph.get(child).stream()
                        .mapToLong(c -> salaries[c])
                        .sum();

                if (sum == 0) {
                    salaries[child] = 1;
                } else {
                    salaries[child] = sum;
                }
            }
        }

        long sum = graph.get(node).stream()
                .mapToLong(c -> salaries[c])
                .sum();

        if (sum == 0) {
            salaries[node] = 1;
        } else {
            salaries[node] = sum;
        }


    }
}

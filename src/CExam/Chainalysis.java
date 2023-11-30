package CExam;

import java.util.*;

public class Chainalysis {

    public static Map<Character, List<Character>> graph = new HashMap<>();
    public static Set<Character> visited = new HashSet<>();

    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edges = Integer.parseInt(scanner.nextLine());

        while (edges-- > 0) {
            String[] pair = scanner.nextLine().split("\\s+");
            char source = pair[0].charAt(0);
            char dest = pair[1].charAt(0);
            int value = Integer.parseInt(pair[2]);

            if (source == dest) {
                continue;
            }





                graph.putIfAbsent(source, new ArrayList<>());
graph.get(source).add(dest);
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(dest).add(source);

        }


        for (char node : graph.keySet()) {
            if (!visited.contains(node)) {
                count++;
                dfs(node);


            }
        }

        System.out.println(count);


    }

    private static void dfs(char node) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        if (graph.get(node) == null) {
            return;
        }



        for (char child : graph.get(node)) {
            if (!visited.contains(child)) {
                dfs(child);
            }

        }
    }
}

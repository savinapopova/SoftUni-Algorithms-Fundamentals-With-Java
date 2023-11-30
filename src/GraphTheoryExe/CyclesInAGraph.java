package GraphTheoryExe;

import java.util.*;

public class CyclesInAGraph {

   public static Map<String, List<String>> graph = new LinkedHashMap<>();
   public static Set<String> visited = new HashSet<>();
   public static Set<String> cycles = new HashSet<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals("End")) {

            String[] pairs = line.split("-");

            graph.putIfAbsent(pairs[0], new ArrayList<>());
            graph.get(pairs[0]).add(pairs[1]);
            line = scanner.nextLine();
        }



        try {
            for (String key : graph.keySet()) {
                if (!visited.contains(key)) {
                    dfs(key);
                }
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Acyclic: Yes");


    }

    private static void dfs(String node) {
        if (cycles.contains(node)) {
            throw new IllegalStateException("Acyclic: No");
        }

        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        cycles.add(node);

        if (graph.get(node) == null) {
            return;
        }

        for (String child : graph.get(node)) {

            dfs(child);
        }

        cycles.remove(node);
    }
}

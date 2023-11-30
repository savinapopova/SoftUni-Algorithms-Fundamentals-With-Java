import java.util.*;
import java.util.stream.Collectors;

public class Main {




    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
         List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String nextLine = scanner.nextLine();

            if (nextLine.trim().equals("")) {
                graph.add(new ArrayList<>());
                continue;
            }

            List<Integer> ints = Arrays.stream(nextLine.split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());
            graph.add(ints);
        }

        List<Deque<Integer>> result = getConnectedComponents(graph);

        for (Deque<Integer> component : result) {
            System.out.print("Connected component: ");
            for (Integer integer : component) {
                System.out.print(integer + " ");

            }
            System.out.println();
        }

    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {

        List<Deque<Integer>> components = new ArrayList<>();

        boolean[] visited = new boolean[graph.size()];

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
               components.add(new ArrayDeque<>());
                dfs(start, visited, components, graph);
            }
        }


        return components;
    }

    private static void bfs(int start, boolean[] visited, List<Deque<Integer>> components, List<List<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            components.get(components.size() - 1).offer(current);

            for (int child : graph.get(current)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }

            }

        }
    }

    private static void dfs(int node, boolean[] visited, List<Deque<Integer>> components, List<List<Integer>> graph) {

        if (node >= graph.size()) {

        return;
    }

        if (!visited[node]) {
            visited[node] = true;


            components.get(components.size() - 1).offer(node);
                for (int child : graph.get(node)) {

                    dfs(child, visited, components, graph);
                }




        }

    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);
        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {

            String current = graph.keySet()
                    .stream().filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst().orElse(null);

            if (current == null) {
                throw new IllegalArgumentException();
            }

            for (String child : graph.get(current)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            graph.remove(current);
            sorted.add(current);


        }

       return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {

        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            dependenciesCount.putIfAbsent(entry.getKey(), 0);
            for (String child : entry.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);

            }
        }

        return  dependenciesCount;
    }
}

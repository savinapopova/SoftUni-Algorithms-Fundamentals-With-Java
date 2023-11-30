import java.util.*;

public class ShortestPath {

    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {

            int[] edge = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            graph.get(edge[0]).add(edge[1]);
        }

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        visited = new boolean[n + 1];
        prevNodes = new int[n + 1];
        Arrays.fill(prevNodes, -1);
        bfs(graph, start, end);

        Deque<Integer> path = new ArrayDeque<>();
        path.push(end);
        int previous = prevNodes[end];

        while (previous != -1) {
            path.push(previous);
            previous = prevNodes[previous];
        }

        System.out.println("Shortest path length is: " + (path.size() - 1));
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }

    }

    private static void bfs(List<List<Integer>> graph, int start, int end) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            if (node == end) {
                return;
            }

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }

    }
}

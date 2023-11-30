package GraphTheoryExe;

import java.util.*;

public class DistanceBetweenVertices {

    public static int[][] graph;
    public static int[] prevNodes;
    public static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int pairsCount = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][];


        for (int i = 1; i < nodes + 1; i++) {

            String[] line = scanner.nextLine().split(":");
            indexMapper.put(Integer.parseInt(line[0]), i);

            if (line.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(line[1].split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }


        while (pairsCount-- > 0) {

            int[] pairs = Arrays.stream(scanner.nextLine().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int source = pairs[0];
            int destination = pairs[1];
            System.out.printf("{%d, %d} -> ", source, destination);
            prevNodes = new int[nodes + 1];
            Arrays.fill(prevNodes, -1);

            bfs(indexMapper.get(source), indexMapper.get(destination));

            List<Integer> path = new ArrayList<>();

            int previous = prevNodes[indexMapper.get(destination)];

            while(previous != -1) {
                path.add(previous);
                previous = prevNodes[previous];
            }
            if (path.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(path.size());
            }
        }



    }

    private static void bfs(Integer source, Integer dest) {

        boolean[] visited = new boolean[graph.length];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            if (node == dest) {
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                int child = indexMapper.get(graph[node][i]);
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                    prevNodes[child] = node;
                }
            }

        }
        prevNodes[source] = -1;
    }
}

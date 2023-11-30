package GraphTheoryExe;

import java.util.*;
import java.util.stream.Collectors;

public class BreakCycles {

    public static Map<String, List<String>> graph = new TreeMap<>();
    public static Set<String> visited = new HashSet<>();
    public static Set<String> cycles = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (line != null && !line.equals("")) {

            String[] edges = line.split(" -> ");
            List<String> children = Arrays.stream(edges[1].split(" ")).collect(Collectors.toList());
            graph.put(edges[0], children);

            line = scanner.nextLine();
        }

        String startNode = null;
        for (String node : graph.keySet()) {
            startNode = node;
            break;
        }

        findCycles(startNode);
    }

    private static void findCycles(String node) {

        if (cycles.contains(node)) {
            return;
        }

        if (visited.contains(node)) {
            return;
        }
        cycles.add(node);
        visited.add(node);

        for (String child : graph.get(node)) {
            if (!visited.contains(child)) {
                findCycles(child);
            }
        }


    }
}

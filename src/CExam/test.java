package CExam;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Map<Character, List<Character>> graph = new LinkedHashMap<>();

        int edges = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 0; i < edges; i++)
     {
            char source = scanner.next().charAt(0);
            char dest = scanner.next().charAt(0);
            int value = scanner.nextInt();
            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(source).add(dest);

        }







        Set<Character> visited = new HashSet<>();
        List<Deque<Character>> elements = new ArrayList<>();

        for (Character character : graph.keySet()) {
            if (!visited.contains(character)) {
                elements.add(new ArrayDeque<>());
                count++;
                bfs(character, elements, graph, visited);
            }
        }

        System.out.println(count);






    }

    private static void bfs(char start, List<Deque<Character>> elements, Map<Character, List<Character>> graph, Set<Character> visited) {
        Deque<Character> queue = new ArrayDeque<>();
        visited.add(start);
        queue.offer(start);


        while (!queue.isEmpty()) {
            char node = queue.poll();

            elements.get(elements.size() - 1).offer(node);

            if (graph.get(node) == null) {
                continue;
            }

            for (char child : graph.get(node)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.offer(child);
                }
            }
        }
    }


    }




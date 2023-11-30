package CExam;

import java.util.*;

public class test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> addresses = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] transaction = scanner.nextLine().split("\\s+");
            String sender = transaction[0];
            String receiver = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            addresses.add(sender);
            addresses.add(receiver);
        }

        int groups = findGroups(addresses, n);
        System.out.println(groups);
    }

    private static int findGroups(Set<String> addresses, int n) {
        Map<String, Integer> indexMap = new HashMap<>();
        List<String> addressList = new ArrayList<>(addresses);
        int count = 0;

        for (int i = 0; i < addressList.size(); i++) {
            indexMap.put(addressList.get(i), i);
        }

        UnionFind unionFind = new UnionFind(addressList.size());

        for (int i = 0; i < n; i++) {
            Scanner scanner = new Scanner(System.in);
            String[] transaction = scanner.nextLine().split("\\s+");
            String sender = transaction[0];
            String receiver = transaction[1];

            int senderIndex = indexMap.get(sender);
            int receiverIndex = indexMap.get(receiver);

            if (unionFind.union(senderIndex, receiverIndex)) {
                count++;
            }
        }

        return count;
    }

    static class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            return true;
        }
    }
}
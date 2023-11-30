package RecursionAndCombinatorialProblems_Exe;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInMatrix {

    public static char[][] matrix;
    public static boolean[][] visited;

    public static List<Area> areas = new ArrayList<>();

    public static int areasCount = 0;

    public static class Area {
        private int row;
        private int col;
        private int count;

        public Area(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][cols];
        visited = new boolean[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] == '-') {
                    areasCount++;
                    int counter = 0;

                    Area area = new Area(row, col, counter);
                    areas.add(area);
                   dfs(row, col, counter);
                }
            }
        }
        Comparator<Area> comparator = (a1, a2) -> {
            int result = a2.getCount() - a1.getCount();
            if (result == 0) {
                result = a1.getRow() - a2.getRow();
            }
            if (result == 0) {
                result = a1.getCol() - a2.getCol();
            }
            return result;
        };
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Total areas found: %d", areas.size()));
        AtomicInteger count = new AtomicInteger(1);

        areas.stream().sorted(comparator)
                .forEach(a -> builder.append(System.lineSeparator())
                        .append(String.format("Area #%d at (%d, %d), size: %d", count.getAndIncrement(),
                        a.getRow(), a.getCol(), a.getCount())));

        System.out.println(builder.toString());


    }

    private static void dfs(int row, int col, int counter) {
        if (outOfBounds(row,col) || matrix[row][col] == '*' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        counter = areas.get(areas.size() - 1).getCount();
        counter++;

        areas.get(areas.size() - 1).setCount(counter);

        dfs(row - 1, col, counter);
        dfs(row, col - 1, counter);
        dfs(row + 1, col, counter);
        dfs(row, col + 1, counter);


    }

    private static boolean outOfBounds(int row, int col) {

        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}

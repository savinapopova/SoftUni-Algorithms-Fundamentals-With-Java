package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth {
    public static char[][] field;

    public static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        field =  new char[rows][cols];
        int currentRow = 0;
        int currentCol = 0;



        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }
//        field[0][0] = 'V';

        findPaths(currentRow, currentCol, 'S');


    }

    private static void findPaths(int currentRow, int currentCol, char direction) {

        if (!isInBounds(currentRow, currentCol) || field[currentRow][currentCol] == 'V'
        || field[currentRow][currentCol] == '*') {
            return;
        }
        path.add(direction);


        if (field[currentRow][currentCol] == 'e') {
            print();
        } else {
            field[currentRow][currentCol] = 'V';
            findPaths(currentRow, currentCol + 1, 'R');
            findPaths(currentRow, currentCol - 1, 'L');
            findPaths(currentRow + 1, currentCol, 'D');
            findPaths(currentRow - 1, currentCol, 'U');
            field[currentRow][currentCol] = '-';
}
        path.remove(path.size() - 1);
    }

    private static boolean isInBounds(int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < field.length && currentCol >= 0 && currentCol < field[currentRow].length;
    }

    public static void print() {
        path.stream().skip(1).forEach(System.out::print);
        System.out.println();

  }


}

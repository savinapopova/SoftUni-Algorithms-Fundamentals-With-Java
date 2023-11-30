package RecursionAndCombinatorialProblems_Exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {

    public static String[] allGirls;
    public static String[] allBoys;
    public static String[] boys = new String[2];
    public static String[] girls = new String[3];
    public static List<String> girlsCombinations = new ArrayList<>();
    public static List<String> boysCombinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        allGirls = scanner.nextLine().split(", ");
        allBoys = scanner.nextLine().split(", ");

        combine(0, 0, allGirls, girls, girlsCombinations);
        combine(0, 0, allBoys, boys, boysCombinations);

        for (String girlsCombination : girlsCombinations) {
            for (String boysCombination : boysCombinations) {
                System.out.println(girlsCombination + ", " + boysCombination);
            }
        }
    }

    private static void combine(int index, int start, String[] all, String[] combinations, List<String> allCombinations ) {
        if (index == combinations.length) {
            allCombinations.add(String.join(", ", combinations));
            return;
        }

        for (int i = start; i < all.length ; i++) {
            combinations[index] = all[i];
            combine(index + 1, i + 1, all, combinations, allCombinations);
        }

    }
}

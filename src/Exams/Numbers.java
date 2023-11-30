package Exams;

import java.util.*;
import java.util.stream.Collectors;


public class Numbers {

    public static int[] numbers;
    public static List<Integer> combinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetSum = Integer.parseInt(scanner.nextLine());


         numbers = new int[targetSum];


        for (int i = 0; i < targetSum; i++) {
            numbers[i] = i + 1;

        }

        List<List<Integer>> combinationSum = combine(targetSum);

        StringBuilder builder = new StringBuilder();

        for (int i = combinationSum.size() - 1; i >= 0; i--) {
            builder.append(
                    combinationSum.get(i).stream()
                            .sorted(Comparator.reverseOrder())
                            .map(String::valueOf)
                            .collect(Collectors.joining(" + ")))
                    .append(System.lineSeparator());



        }

        System.out.println(builder.toString());

    }

    private static List<List<Integer>> combine(int targetSum) {
        return combine(targetSum, new HashMap<>());
    }

    private static  List<List<Integer>> combine(int targetSum, Map<Integer, List<List<Integer>>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        List<List<Integer>> result = new ArrayList<>();
        if (targetSum == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        if (targetSum < 0) {
            return result;
        }

        for (int number : numbers) {
            int newTarget = targetSum - number;
            List<List<Integer>> lists = combine(newTarget, memo);

            for (List<Integer> list : lists) {
                List<Integer> tempList = new ArrayList<>(list);
                if (tempList.isEmpty() ||
                        tempList.get(tempList.size() -1) <= number) {
                    tempList.add(number);
                    result.add(tempList);
                }
            }
        }
        memo.put(targetSum, result);
        return result;

    }


}

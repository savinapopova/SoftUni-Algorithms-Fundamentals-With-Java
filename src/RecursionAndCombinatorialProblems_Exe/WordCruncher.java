package RecursionAndCombinatorialProblems_Exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class WordCruncher {

    public static List<String> substrings = new ArrayList<>();
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> counterMap = new HashMap<>();
    public static String target;
    public static Set<String> out = new TreeSet<>();
    public static List<String> result = new ArrayList<>();




    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        substrings = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        target = reader.readLine();


        substrings.removeIf(e -> !target.contains(e));

        for (String substr : substrings) {
            int index = target.indexOf(substr, 0);
            counterMap.putIfAbsent(substr, 0);
            counterMap.put(substr, counterMap.get(substr) + 1);
            while (index != -1) {

                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(substr);
                index = target.indexOf(substr, index + 1);

            }
        }



        solve(0);
        for (String s : out) {
            System.out.println(s);
        }
    }

    private static void solve(int index) {


     if (index == target.length()) {
         out.add(String.join(" ", result));

         return;
     }
            if (table.containsKey(index)) {

                List<String> strings = table.get(index);

                for (String string : strings) {
                    if (counterMap.get(string) > 0) {
                        result.add(string);
                        counterMap.put(string, counterMap.get(string) - 1);
                        solve(index + string.length());
                        result.remove(result.size() - 1);
                        counterMap.put(string, counterMap.get(string) + 1);

                    }
                }
            }

     }


}

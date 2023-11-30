package RecursionAndCombinatorialProblems_Exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Cinema {

  public static List<String> names;
  public static String[] result;

  public static boolean[] used;
  public static int count;
    public static Map<Integer, String> takenSeats = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        names = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toList());
        count = names.size();


    String input = reader.readLine();

        while (!input.equals("generate")) {
            String name = input.split(" - ")[0];
            int seat = Integer.parseInt(input.split(" - ")[1]);
            takenSeats.put(seat, name);
            names.remove(name);
            input = reader.readLine();
        }



        used = new boolean[names.size()];

        result = new String[names.size()];


        findSeats(0);
    }

    private static void findSeats(int index) {
        if (index == names.size()) {
            print();
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                result[index] = names.get(i);
                findSeats(index + 1);
                used[i] = false;
            }
        }


    }

    private static void print() {
        int index = 0;
//        Map<Integer, String> resultSeats = new TreeMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            if (!takenSeats.containsKey(i)) {
//                resultSeats.put(i, result[index]);
                builder.append(result[index]).append(" ");
                index++;
            } else {
//                resultSeats.put(i, takenSeats.get(i));
                builder.append(takenSeats.get(i)).append(" ");
            }
        }
        System.out.println(builder.toString().trim());
//        System.out.println(resultSeats.values().toString().replaceAll("[\\[\\],]", ""));
    }

}

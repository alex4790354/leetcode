package com.github.alex4790354.p00StreamIP;

import java.util.*;
import java.util.stream.Collectors;

public class StremIP {

    public static void main(String[] args) {

        List<Integer> myIntegers = Arrays.asList(1, 3, 7, 81, 13, 56, 23);

    /*    System.out.println(calculateAverage(myIntegers));

        System.out.println(convertToUpperCase("abc"));
        System.out.println(evenSumm(myIntegers));

        List<String> myString = Arrays.asList("aa", "bb", "cc", "aa", "cc", "aaa");

        System.out.println(removeDuplicates(myString));
        System.out.println(charsCount(myString, "a"));
        System.out.println(sortList(myString));*/

        List<String> logAsString = Arrays.asList("Error",
                "ERROR [thread [gbxb [bbb]] - 1] qaeq ybz",
                "ERROR [thread [xcde [aqx]] - 0] wyqe",
                "ERROR [thread [wxcf [czed [ayqa [fye]]]] - 0] eaba yzd",
                "DEBUG [thread [zqfz [wbqe [zfq]]] - 1] [cz] bxa",
                "WARNING [thread [xcde [aqx]] - 0] dbdf wey",
                "ERROR [thread [gbxb [bbb]] - 1] zqz",
                "INFO [thread [xcde [aqx]] - 0] fqwx [yc] exb",
                "ERROR [thread [gbxb [bbb]] - 1] qaeq",
                "ERROR [thread [xcde [aqx]] - 0] [xf]",
                "DEBUG [thread [wxcf [czed [ayqa [fye]]]] - 0] gqca",
                "ERROR [thread [wxcf [czed [ayqa [fye]]]] - 0] cfqb [ed]",
                "WARNING [thread [wxcf [czed [ayqa [fye]]]] - 0] wey",
                "ERROR [thread [wxcf [ayqa [fye]]] - 0] ebew [q]",
                "INFO [thread [xcx] - 0] dwwf wbd",
                "DEBUG [thread [wxcf [ayqa [fye]]] - 0] ybqax",
                "INFO [thread [wxcf [czed [ayqa [fye]]]] - 0] [yb]",
                "DEBUG [thread [ayqa [fye]]] - 1] wzq",
                "ERROR [thread [gbxb [bbb]] - 1] bzqe eba",
                "WARNING [thread [zqfz [wbqe [zfq]]] - 1] wqaa [e] zqw"
        );

        logAsString.stream()
                .filter(c -> c.startsWith("ERROR"))

        ;

        String singleLog = "WARNING [thread [zqfz [wbqe [zfq]]] - 1] wqaa [e] zqw";

        System.out.println(splitIntoThreeParts(singleLog)[0] +
                " |2| " +  splitIntoThreeParts(singleLog)[1] +
                " |3| " +  splitIntoThreeParts(singleLog)[2]);

    }

    public static String[] splitIntoThreeParts(String input) {
        String[] parts = input.split(" ", 3);

        if (parts.length == 1) {
            return new String[]{parts[0], "", ""};
        } else if (parts.length == 2) {
            return new String[]{parts[0], parts[1], ""};
        } else {
            return parts;
        }
    }

    // 1) calculate the average of a list of integers using streams.
    public static String calculateAverage(List<Integer> numbers) {
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0); // Возвращает 0.0, если поток пустой
        /*
            int[] numbers = {1, 3, 7, 8, 12, 56, 23};
            Double resultDouble = IntStream.of(numbers).average().orElse(0.0);
            String resultString = String.format("%.1f", resultDouble);
         */
        // Округление до второго знака после запятой
        return String.format("%.2f", average);
    }

    // 2) convert a list of strings to uppercase or lowercase using streams
    public static String convertToUpperCase(String input) {
        return input.chars()
                .mapToObj(c -> Character.toString(Character.toUpperCase(c)))
                .collect(Collectors.joining());
    }

    // 3) Сумма четных
    public static Integer evenSumm(List<Integer> input) {
        return input.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i % 2 == 1)
                .sum();
    }

    // 4) Remove duplicates
    public static String removeDuplicates(List<String> s) {
        return s.stream()
                .distinct()
                .collect(Collectors.joining());
    }

    // 5) count the number of strings in a list that start with a specific letter
    public static int charsCount(List<String> s, String start) {
        return s.stream()
                .filter(c -> c.startsWith(start))
                .mapToInt(c -> c.length())
                .sum();

    }

    // 6) sort a list of strings in alphabetical order, ascending and descending
    public static List<String> sortList(List<String> s) {
        return s.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // 7)  find the maximum and minimum values in a list of integers using streams
    public static int findMaximum(List<Integer> s) {

        return s.stream()
                .mapToInt(Integer::intValue)
                .max()
                // or .min()
                .orElse(0);
    }

    // 8)  find second smallest and largest elements in a list of integers using streams
    public static int findSecondMax(List<Integer> s) {

        return s.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(0);
    }



}

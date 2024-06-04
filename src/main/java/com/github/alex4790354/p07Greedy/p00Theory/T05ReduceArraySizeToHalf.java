package com.github.alex4790354.p07Greedy.p00Theory;

import java.lang.reflect.Array;
import java.util.*;

public class T05ReduceArraySizeToHalf {

    public static void main(String[] args) {

        T05ReduceArraySizeToHalf test = new T05ReduceArraySizeToHalf();

        int[] arr1 = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int[] arr2 = {7, 7, 7, 7, 7, 7};

        System.out.println(test.solution(arr1)); // Ожидаемый результат: 2
        System.out.println(test.solution(arr2)); // Ожидаемый результат: 1
    }

    private int solution(int[] arr) {
        int result = 0, arrLength = arr.length, removed = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int key : arr) {
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies, Comparator.reverseOrder());

        for (Integer i : frequencies) {
            result++;
            removed += i;
            if (removed * 2 >= arrLength)
                return result;
        }
        return result;
    }

}

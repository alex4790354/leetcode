package com.github.alex4790354.p07Greedy.p00Theory;

import java.util.*;

/**  You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

     Return the minimum size of the set so that at least half of the integers of the array are removed.

     Example 1:
     Input: arr = [3,3,3,3,5,5,5,2,2,7]
     Output: 2
     Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
     Possible sets of size 2 are {3,5},{3,2},{5,2}.
     Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.

 */

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

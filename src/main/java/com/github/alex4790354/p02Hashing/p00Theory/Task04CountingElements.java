package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashMap;
import java.util.Map;

/** Given a string s, determine if all characters have the same frequency.
    For example, given s = "abacbc", return true. All characters appear twice. Given s = "aaabb", return false. "a" appears 3 times, "b" appears 2 times. 3 != 2.
 *
 */
public class Task04CountingElements {

    public static void main(String[] args) {
        System.out.println(countingElements(new int[]{1, 2}));
    }

    private static int countingElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int num : arr) {
            if (map.containsKey(num + 1)) {
                result++;
            }
        }
        return result;
    }
}

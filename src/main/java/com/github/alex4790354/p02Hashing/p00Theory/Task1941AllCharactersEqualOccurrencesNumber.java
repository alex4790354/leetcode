package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/** Given a string s, determine if all characters have the same frequency.
    For example, given s = "abacbc", return true. All characters appear twice.
    Given s = "aaabb", return false. "a" appears 3 times, "b" appears 2 times. 3 != 2.
 */
public class Task1941AllCharactersEqualOccurrencesNumber {

    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(counts.values());
        return set.size() == 1;
    }

}

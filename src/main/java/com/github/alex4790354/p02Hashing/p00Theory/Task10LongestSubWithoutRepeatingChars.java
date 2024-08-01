package com.github.alex4790354.p02Hashing.p00Theory;

import org.apache.logging.log4j.util.Chars;
import java.util.HashMap;
import java.util.Map;

/** Given a string s, find the length of the longest substring without repeating characters
 *  Example 1:
 *  Input: s = "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 *  Example 2:
 *  Input: s = "bbbbb"
 *  Output: 1
 *  Explanation: The answer is "b", with the length of 1. *
 */


public class Task10LongestSubWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put( s.charAt(1), 1);
        int left = 0, right = 0, maxCount = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

        }

        return maxCount;
    }

}

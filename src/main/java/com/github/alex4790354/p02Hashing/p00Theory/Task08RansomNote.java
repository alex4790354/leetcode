package com.github.alex4790354.p02Hashing.p00Theory;


/** Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters
 * from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * Example 1:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * Example 2: *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 */

public class Task08RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] numbers = new int[28];

        for (char c : magazine.toCharArray()) {
            numbers[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (numbers[c - 'a'] == 0)
                return false;
            numbers[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(canConstruct("aab", "bbaacc"));

    }



}

package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashSet;
import java.util.Set;

public class Task02Pangram {
    public static void main(String[] args) {
        String word = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(isPangram(word));
    }

    private static boolean isPangram(String word) {
        String allChars = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> alphabet = new HashSet<>();
        for (Character c : allChars.toCharArray()) {
            alphabet.add(c);
        }

        for (Character c : word.toCharArray()) {
            alphabet.remove(c);
        }
        return alphabet.isEmpty();
    }

}

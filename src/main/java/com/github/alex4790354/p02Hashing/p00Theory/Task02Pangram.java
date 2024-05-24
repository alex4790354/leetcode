package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashSet;
import java.util.Set;

public class Task02Pangram {
    public static void main(String[] args) {
        String word = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(isPangram(word));
    }

    private static boolean isPangram(String sentence) {
        String alphabetChars = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> alphabetSet = new HashSet<>();
        for (Character c : alphabetChars.toCharArray()) {
            alphabetSet.add(c);
        }

        for (int i = 0; i < sentence.length(); i++) {
            alphabetSet.remove(sentence.charAt(i));
        }
        return alphabetSet.isEmpty();
    }

}

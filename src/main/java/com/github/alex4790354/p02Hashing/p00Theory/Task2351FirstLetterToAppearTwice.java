package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashSet;
import java.util.Set;


public class Task2351FirstLetterToAppearTwice {

    public static void main(String[] args) {
        String word = "Hello World";
        System.out.println(firstLetter(word));
    }

    private static Character firstLetter(String word) {
        Set<Character> set = new HashSet<>();
        Character curChar;

        for (int i = 0; i < word.length(); i++) {
            curChar = word.charAt(i);
            if (set.contains(curChar)) {
                return curChar;
            }
            set.add(curChar);
        }

        return null;
    }

}

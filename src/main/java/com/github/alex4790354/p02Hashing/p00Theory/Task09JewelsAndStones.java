package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashSet;
import java.util.Set;

public class Task09JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelsSet.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelsSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Task09JewelsAndStones js = new Task09JewelsAndStones();
        System.out.println(js.numJewelsInStones("aA", "aAAbbbb")); // Output: 3
        System.out.println(js.numJewelsInStones("z", "ZZ"));       // Output: 0
    }
}

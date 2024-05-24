package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashMap;
import java.util.Map;

public class Task07MaxNumOfBalloons {

    public static void main(String[] args) {
        String text = "balloon";

        System.out.println(solution(text));
    }

    private static int solution(String text) {
        String ban = "ban";
        String lo = "lo";
        Integer result = Integer.MAX_VALUE;
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : "balloon".toCharArray()) {
            counts.put(c, 0);
        }
        for (char c : text.toCharArray()) {
            if (ban.contains(c + "")) {
                counts.put(c, counts.get(c) + 2);
            } else if (lo.contains(c + "")) {
                counts.put(c, counts.get(c) + 1);
            }
        }

        for (int num : counts.values()) {
            result = Math.min(num / 2, result);
        }
        if (result == Integer.MAX_VALUE) {
            result = 0;
        }
        return result;
    }
}

package com.github.alex4790354.p07Greedy.p00Theory;

import java.util.Arrays;

public class T01DestroyingAsteroids {
    public static void main(String[] args) {
        String[] asteroids = {"3", "5", "1", "8"};
        Arrays.sort(asteroids);
        System.out.println(Arrays.toString(asteroids));
        System.out.println(Arrays.deepToString(asteroids));
    }

    private boolean solution(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int asteroid: asteroids) {
            if (asteroid > currMass) {
                return false;
            }
            currMass += asteroid;
        }
        return true;
    }
}

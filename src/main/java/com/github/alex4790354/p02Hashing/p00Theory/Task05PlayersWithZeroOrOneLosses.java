package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.*;

public class Task05PlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(solution(matches));
    }

    private static List<List<Integer>> solution(int[][] matches) {
        Set<Integer> noLoses = new HashSet<>();
        Set<Integer> oneLoss = new HashSet<>();
        Map<Integer, Integer> loses = new HashMap<>();
        for (int[] arr : matches) {
                noLoses.add(arr[0]);
                loses.put(arr[1], loses.getOrDefault(arr[1], 0) + 1);
        }

        for (Integer key : loses.keySet()) {
            noLoses.remove(key);
            if (loses.get(key) == 1) {
                oneLoss.add(key);
            }
        }
        List<Integer> noLosesArray = noLoses.stream().mapToInt(Integer::intValue).sorted().boxed().toList();
        List<Integer> oneLossArray = oneLoss.stream().mapToInt(Integer::intValue).sorted().boxed().toList();
        List<List<Integer>> result = new ArrayList<>();
        result.add(noLosesArray);
        result.add(oneLossArray);
        return result;
    }

}

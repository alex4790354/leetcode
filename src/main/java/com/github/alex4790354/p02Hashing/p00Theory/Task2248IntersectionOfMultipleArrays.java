package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** Given a 2D array nums that contains n arrays of distinct integers, return a sorted array containing all the numbers that appear in all n arrays.
    For example, given nums = [[3,1,2,4,5], [1,2,3,4], [3,4,5,6]], return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
 */
public class Task2248IntersectionOfMultipleArrays {

    public static void main(String[] args) {
        int[][] nums= new int[][] {{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6}};
        for (var num : solution(nums)) {
            System.out.println(num);
        }
    }

    private static List<Integer> solution(int[][] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] numA : nums) {
            for (int numB : numA) {
                map.put(numB, map.getOrDefault(numB, 0) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == nums.length) {
                result.add(key);
            }
        }
        return result;
    }
}

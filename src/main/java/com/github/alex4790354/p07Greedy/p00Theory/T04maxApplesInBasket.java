package com.github.alex4790354.p07Greedy.p00Theory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/** You have some apples and a basket that can carry up to 5000 units of weight.
 *  Given an integer array weight where weight[i] is the weight of the ith apple, return the maximum number of apples you can put in the basket.

 *  Input: weight = [100,200,150,1000]
 *  Output: 4
 *  Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
 */

public class T04maxApplesInBasket {

    public static void main(String[] args) {
        int[] weigth = {900,950,800,1000,700,800};
        T04maxApplesInBasket test = new T04maxApplesInBasket();
        System.out.println(test.solution(weigth));
    }

    private int solution(int[] weight) {

        int result = 0, backetWeight = 0;
        Arrays.sort(weight);
        //reverseOrder if need it: Arrays.sort(Arrays.stream(weight).boxed().toArray(), Collections.reverseOrder());
        for (int i : weight) {
            if (backetWeight + i <= 5000) {
                backetWeight += i;
                result++;
            } else {
                return result;
            }
        }
        return result;
    }

}

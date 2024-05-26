package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.Stack;
import java.util.stream.Collectors;

/** You are given a string s. Continuously remove duplicates (two of the same character beside each other) until you can't anymore.
 *  Return the final string after this.
 *  For example, given s = "abbaca", you can first remove the "bb" to get "aaca".
 *  Next, you can remove the "aa" to get "ca". This is the final answer. *
 */
public class T02RemoveDuplicates {

    public static void main(String[] args) {
        String word = "leelcode";
        T02RemoveDuplicates test = new T02RemoveDuplicates();
        System.out.println(test.solution(word));
    }

    private String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

}

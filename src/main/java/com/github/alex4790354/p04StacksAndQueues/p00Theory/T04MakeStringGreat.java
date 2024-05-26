package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

/** A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *  Input: s = "leEeetcode" =>  Output: "leetcode"
 *  Input: s = "abBAcC" => Output: ""
 */
public class T04MakeStringGreat {

    public static void main(String[] args) {
        String s = "Pp";
        T04MakeStringGreat t = new T04MakeStringGreat();
        System.out.println(t.solution(s));
    }

    private String solution(String s) {
        Stack<String> stack = new Stack<>();
        String current;
        for (char c : s.toCharArray()) {
            current = String.valueOf(c);
            if (stack.isEmpty()) {
                stack.push(current);
                continue;
            }
            if (!stack.peek().equals(current) &&
                    (stack.peek().equals(current.toLowerCase()) ||
                     stack.peek().toLowerCase().equals(current))
               ) {
                stack.pop();
            } else
                stack.push(current);
        }

        return stack.stream().map(Objects::toString).collect(Collectors.joining());
    }
}

package com.github.alex4790354.p04StacksAndQueues.p00Theory;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  The string is valid if all open brackets are closed by the same type of closing bracket in the correct order,
 *  and each closing bracket closes exactly one open bracket.
 *  For example, s = "({})" and s = "(){}[]" are valid, but s = "(]" and s = "({)}" are not valid.
 */
public class T01ValidParentheses {

    public static void main(String[] args) {
        String parentheses = "{[(())]}";
        T01ValidParentheses test = new T01ValidParentheses();
        System.out.println(test.isValid(parentheses));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            }

            if (stack.isEmpty())
                return false;

            char top = stack.pop();
            if (top != map.get(c)) {
                return false;
            }

        }
        return stack.isEmpty();
    }

}

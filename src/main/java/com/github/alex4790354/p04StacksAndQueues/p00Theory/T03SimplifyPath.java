package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.Stack;


/** Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
 *  In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level,
 *  and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules
 *  (like "...") as valid names for files or directories.
 *  The simplified canonical path should adhere to the following rules:
        - It must start with a single slash '/'.
        - Directories within the path should be separated by only one slash '/'.
        - It should not end with a slash '/', unless it's the root directory.
        - It should exclude any single or double periods used to denote current or parent directories.
 */
public class T03SimplifyPath {

    public static void main(String[] args) {
        String path = "/home/user/.../Documents/../Pictures";
        T03SimplifyPath test = new T03SimplifyPath();
        System.out.println(test.solution(path));
    }

    private String solution(String path) {
        Stack<String> stack = new Stack<String>();

        String[] split = path.split("/");
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    stack.pop();
                }
            } else if (s.equals("//") || s.equals(".") || s.isEmpty()) {
            } else {
                stack.push("/");
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            stack.push("/");
        }

        return String.join("", stack);
    }

}

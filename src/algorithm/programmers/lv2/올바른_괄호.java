package algorithm.programmers.lv2;

import java.util.*;

/**
 * 2024-03-28
 * 올바른 괄호 (Lv1)
 * solved ✅
 */
public class 올바른_괄호 {
    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return result;
    }
}

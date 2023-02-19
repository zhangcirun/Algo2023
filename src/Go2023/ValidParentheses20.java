package Go2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || stack.peek() != closeToOpen.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

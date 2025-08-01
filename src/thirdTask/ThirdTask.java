package thirdTask;

import java.util.Stack;

public class ThirdTask {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println("Сбалансирована ли строка: " + s + ": " + isBalanced(s));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> characters = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characters.push(c);
            }
            else {
                if (characters.isEmpty()) {
                    return false;
                }

                if (c == ')' && (characters.pop() != '(')) {
                    return false;
                }
                if (c == '}' && (characters.pop() != '{')) {
                    return false;
                }
                if (c == ']' && (characters.pop() != '[')) {
                    return false;
                }
            }
        }

        return characters.isEmpty();
    }
}

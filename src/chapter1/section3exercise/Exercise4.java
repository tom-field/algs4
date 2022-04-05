package chapter1.section3exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {
    public static void main(String[] args) {
        Exercise4 ex4 = new Exercise4();
        StdOut.println(ex4.isBalanced("[()]{}{[()()]()}"));
        StdOut.println(ex4.isBalanced("[(])"));
    }

    private boolean isBalanced(String input) {
        char[] parentheses = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses) {
            if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
                stack.push(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char firstItem = stack.pop();
                if (parenthesis == ')' && firstItem != '('
                        || parenthesis == ']' && firstItem != '['
                        || parenthesis == '}' && firstItem != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

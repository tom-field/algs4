package chapter1.section3exercise;

import edu.princeton.cs.algs4.StdOut;

// 中序表达式转后序
public class Exercise10 {
    public static void main(String[] args) {
        String infixExpression = "( ( 1 + 2 ) * ( 4 / 2 ) )";
        String postFixExpression = infixToPostfix(infixExpression);

        StdOut.println("Postfix expression: " + postFixExpression);
        StdOut.println("Expected: 1 2 + 4 2 / *");
    }
    private static String infixToPostfix(String infixExpression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] inputValues = infixExpression.split("\\s");

        for (String value : inputValues) {
            if (value.equals("(")) {
                // do nothing
            } else if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                operators.push(value);
            } else if (value.equals(")")) {
                String value2 = operands.pop();
                String value1 = operands.pop();
                String operator = operators.pop();

                String newExpression = value1 + " " + value2 + " " + operator;
                operands.push(newExpression);
            } else {
                operands.push(value);
            }
        }
        return operands.pop();
    }
}

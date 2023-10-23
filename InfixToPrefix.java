import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        String result;
        System.out.println("Enter the string");
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9')
                operand.push("" + ch);
            else if (ch == ')') {
                while (operator.peek() != '(') {
                    String v2 = operand.pop();
                    String v1 = operand.pop();
                    result = operator.pop() + v1 + v2;
                    operand.push(result);
                }
                operator.pop();
            } 
            else if (operator.isEmpty() || ch == '(' || operator.peek() == '(')
                operator.push(ch);
            else {
                if (!InfixEvaluation.precedence(ch, operator.peek())) { // calling precedence function from class InfixEvaluation                                                                        
                    String v2 = operand.pop();
                    String v1 = operand.pop();
                    result = operator.pop() + v1 + v2;
                    operand.push(result);
                }
                operator.push(ch);
            }
        }
            while (!operator.isEmpty()) {
                String v2 = operand.pop();
                String v1 = operand.pop();
                result = operator.pop() + v1 + v2;
                operand.push(result);
            }
            System.out.println("The result is: " + operand.peek());
            sc.close();
        
    }
}

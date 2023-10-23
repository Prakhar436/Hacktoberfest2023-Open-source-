import java.util.*;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int ascii, result;
        System.out.println("Enter the expression without spaces");
        String s = sc.next();
        char[] exp = s.toCharArray();
        for (char c : exp) {
            ascii = (int) c;
            if (ascii >= 48 && ascii <= 57)
                operand.push(ascii - 48);
            else if (c == ')') {
                while (operator.peek() != '(') {
                    result = solve(operand.pop(), operand.pop(), operator.pop());
                    operand.push(result);
                }
                operator.pop();
            }
            else if(operator.isEmpty()||c=='('||operator.peek()=='(')
                operator.push(c);
            else 
            {
                if (!precedence(c, operator.peek())) {
                    result = solve(operand.pop(), operand.pop(), operator.pop());
                    operand.push(result);
                }
                operator.push(c);
            }
        }
        while(!operator.isEmpty()){
            result = solve(operand.pop(), operand.pop(), operator.pop());
            operand.push(result);   
        }
        System.out.println("The result is: "+operand.peek());
        sc.close();
    }

    public static int solve(int val2, int val1, char ch) {
        int result = 0;
        switch (ch) {
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                result = val1 / val2;
                break;
        }
        return result;
    }

    public static boolean precedence(char op1, char op2) // returns true if given operator has higher precedence than
                                                         // top of operator stack
    {
        return ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));
    }
}

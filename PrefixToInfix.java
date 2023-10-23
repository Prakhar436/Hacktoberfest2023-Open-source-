import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        Stack<String> operand = new Stack<>();
        String s = "-9/*+5346";
        char exp[] = s.toCharArray();
        for (int i = exp.length-1; i>=0; i--) {
            char c = exp[i];
            if (c >= '0' && c <= '9')
                operand.push(c + "");
            else {
                String converted  = "(" + operand.pop() + c + operand.pop() + ")"; //val1 + val2 + operator
                operand.push(converted);
            }
        }
        System.out.println("The result is " + operand.peek());
        }
}

import java.util.Stack;
import java.util.Scanner;

public class PostFixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> operand = new Stack<>();
        System.out.println("Enter the postfix string ");
        String s = sc.next();
        char exp[] = s.toCharArray();
        for (char c : exp) {
            if (c >= '0' && c <= '9')
                operand.push(c - '0');
            else {
                int result = InfixEvaluation.solve(operand.pop(), operand.pop(), c); // calling solve() function from
                                                                                     // InfixEvaluation class
                operand.push(result);
            }
        }
        System.out.println("The result is " + operand.peek());
        sc.close();

    }
}
//953+4*6/-
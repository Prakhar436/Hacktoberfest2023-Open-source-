import java.util.*;
public class NextGreaterElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int a[] = {2,3,4,5,1,2,4,4,7,10};
        int res[] = new int[a.length];
        res[a.length - 1] = -1;
        stack.push(a[a.length-1]);
        for(int i=a.length-2;i>=0;i--){
            while (stack.size()>0 && stack.peek()<=a[i]) {
                stack.pop();
            }
            if(stack.size()==0) res[i] = -1;
            else res[i] = stack.peek();
            stack.push(a[i]);
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}

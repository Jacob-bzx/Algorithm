package chapter1_stack_and_queue;

import java.util.Stack;

public class Problem_03_ReverseStackUsingRecursive {
    public static void reverse(Stack<Integer> s){
        if (s.isEmpty()) {
            return;
        }
        int val = getLastAndRemove(s);
        reverse(s);
        s.push(val);
    }

    public static int getLastAndRemove(Stack<Integer> s) {
        int val = s.pop();
        if (s.isEmpty()) {
            return val;
        }
        int res = getLastAndRemove(s);
        s.push(val);
        return res;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            s.push(i);
        }
        reverse(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}

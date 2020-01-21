package chapter1_stack_and_queue;

import java.util.Stack;

public class Problem_05_StackSortStack {
    public static void sortByStack(Stack<Integer> s){
        Stack<Integer> help = new Stack<>();
        while (!s.isEmpty()) {
            int cur = s.pop();
            if (help.isEmpty() || cur <= help.peek()) {
                help.push(cur);
            } else {
                while(!help.isEmpty()){
                    s.push(help.pop());
                }
                help.push(cur);
            }
        }
        while (!help.isEmpty()) {
            s.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(10);
        s.push(2);
        s.push(9);
        s.push(3);
        s.push(8);
        s.push(4);
        s.push(7);
        sortByStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

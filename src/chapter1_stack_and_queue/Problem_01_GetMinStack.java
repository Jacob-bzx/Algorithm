package chapter1_stack_and_queue;

import java.util.Stack;

public class Problem_01_GetMinStack {
    public static class MyStack {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public int pop(){
            if(stack1.peek().equals(stack2.peek())){
                stack2.pop();
            }
            return stack1.pop();
        }

        public void push(int num){
            stack1.push(num);
            if (stack2.isEmpty() || num <= stack2.peek()) {
                stack2.push(num);
            }
        }

        public int getMin(){
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack stack2 = new MyStack();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}

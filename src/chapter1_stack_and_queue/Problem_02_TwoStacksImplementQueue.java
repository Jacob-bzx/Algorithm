package chapter1_stack_and_queue;

import java.util.Stack;

public class Problem_02_TwoStacksImplementQueue {
    public static class MyQueue{
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        public void add(int num){
            s1.add(num);
        }
        public int poll(){
            transfer();
            return s2.pop();
        }
        public int peek(){
            transfer();

            return s2.peek();
        }

        private void transfer(){
            if(s2.isEmpty()){
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}

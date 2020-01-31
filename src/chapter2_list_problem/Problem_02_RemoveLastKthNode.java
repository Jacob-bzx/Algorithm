package chapter2_list_problem;

public class Problem_02_RemoveLastKthNode {

    public static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){
            return head.next;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth<0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }


    
}

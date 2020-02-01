package chapter2_list_problem;

public class Problem_18_InsertNumToCircularList {
    public static Node insertNum(Node head, int num) {
        if (head == null) {
            Node res = new Node(num);
            res.next = res;
            return res;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && num <= cur.value) {
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        Node newNode = new Node(num);
        pre.next = newNode;
        pre.next.next = cur;
        return num <= head.value ? newNode : head;


    }

    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNum(head, 2);
        printCircularList(head);
        head = insertNum(head, 1);
        printCircularList(head);
        head = insertNum(head, 4);
        printCircularList(head);
        head = insertNum(head, 3);
        printCircularList(head);
        head = insertNum(head, 5);
        printCircularList(head);
        head = insertNum(head, 0);
        printCircularList(head);

    }
}

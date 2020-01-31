package chapter2_list_problem;

public class Problem_06_JosephusProblem {
    public static Node josephusKill1(Node head, int m) {
        if (m == 1) {
            Node cur = head;
            while (cur.next != head) {
                cur = cur.next;
            }
            return cur;
        }

        while (head.next != head) {
            Node pre = null;
            for (int i = 1; i < m; i++) {
                pre = head;
                head = head.next;
            }
            pre.next = head.next;
            head = head.next;

        }
        return head;

    }

    public static Node josephusKill2(Node head, int m) {
        int count = 1;
        Node cur = head.next;
        while (cur != head) {
            count++;
            cur = cur.next;
        }
        int index = f(count, m);
        while (--index > 0) {
            head=head.next;
        }
        head.next=head;
        return head;
    }

    public static int f(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return (f(n - 1, m) + m-1) % n+1;
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
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1;
        printCircularList(head1);
        head1 = josephusKill1(head1, 3);
        printCircularList(head1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = head2;
        printCircularList(head2);
        head2 = josephusKill2(head2, 3);
        printCircularList(head2);

    }
}

package chapter1_stack_and_queue;

import java.awt.image.TileObserver;

public class Problem_06_HanoiStack {
    static final int LEFT=0;
    static final int MID=1;
    static final int RIGHT=2;
    static final int SUM = LEFT + MID + RIGHT;
    static String[] pos = {"left", "mid", "right"};
    static int count=0;
    static String out="Move %s from %s to %s";
    public static void move(int n, int from, int to) {
        if(n==0){
            return;
        }

        if(from==MID){
            move(n - 1, from, SUM - from - to);
            System.out.println(String.format(out, n, pos[from], pos[to]));
            count++;
            move(n - 1, SUM - from - to, from);
            move(n - 1, from, to);
        } else if (to == MID) {
            move(n - 1, from, to);
            move(n - 1, to, SUM - from - to);
            System.out.println(String.format(out, n, pos[from], pos[to]));
            count++;
            move(n - 1, SUM - from - to, to);
        } else {
            move(n - 1, from, MID);
            move(n - 1, MID, to);
            System.out.println(String.format(out, n, pos[from], pos[MID]));
            count++;
            move(n - 1, to, MID);
            move(n - 1, MID, from);
            System.out.println(String.format(out, n, pos[MID], pos[to]));
            count++;

            move(n - 1, from, MID);
            move(n - 1, MID, to);
        }
    }

    public static void main(String[] args) {
        move(4, LEFT, RIGHT);
        System.out.println("It will move "+count+" steps.");
    }
}

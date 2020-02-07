package chapter8_array_and_matrix;

import java.util.*;

public class Problem_29_BuildingProfile {
    public static class Node {
        int index;
        boolean isAdd;
        int height;

        public Node(int index, boolean isAdd, int height) {
            this.index = index;
            this.isAdd = isAdd;
            this.height = height;
        }
    }

    public static List<List<Integer>> getBuildingProfile(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int N = matrix.length;

        Node[] nodes = new Node[2 * N];
        for (int i = 0; i < N; i++) {
            nodes[2 * i] = new Node(matrix[i][0], true, matrix[i][2]);
            nodes[2 * i + 1] = new Node(matrix[i][1], false, matrix[i][2]);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.index != o2.index) {
                return o1.index - o2.index;
            }
            if (o1.isAdd != o2.isAdd) {
                return o1.isAdd ? -1 : 1;
            }
            return 0;
        });

        TreeMap<Integer, Integer> height2Count = new TreeMap<>();
        TreeMap<Integer, Integer> xIndex2MaxHeight = new TreeMap<>();

        for (Node node : nodes) {
            if (node.isAdd) {
                height2Count.put(node.height, height2Count.getOrDefault(node.height, 0) + 1);
            } else {
                if (height2Count.get(node.height) == 1) {
                    height2Count.remove(node.height);
                } else {
                    height2Count.put(node.height, height2Count.get(node.height) - 1);
                }
            }

            if (height2Count.isEmpty()) {
                xIndex2MaxHeight.put(node.index, 0);
            } else {
                xIndex2MaxHeight.put(node.index, height2Count.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        int preHeight = 0;
        int start = 0;
        for (Map.Entry<Integer, Integer> entry : xIndex2MaxHeight.entrySet()) {
            int xIndex = entry.getKey();
            int height = entry.getValue();
            if (height != preHeight) {
                if (preHeight != 0) {
                    res.add(Arrays.asList(start, xIndex, preHeight));
                }
                preHeight=height;
                start=xIndex;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[][] arr = {{2, 5, 6}, {1, 7, 4,}, {4, 6, 7}, {3, 6, 5}, {10, 13, 2}, {9, 11, 3}, {12, 14, 4}, {10, 12, 5}};
        System.out.println(getBuildingProfile(arr));
    }
}

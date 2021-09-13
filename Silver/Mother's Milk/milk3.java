/*
    ID:
    LANG: JAVA
    TASK: milk3
*/

import java.util.*;
import java.io.*;

class milk3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] maximums = new int[3];
        for (int i = 0; i < 3; i++) {
            maximums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> options = new ArrayList<Integer>();

        Stack<Node> stack = new Stack<Node>();
        boolean[][][] check = new boolean[21][21][21];
        Node root = new Node(0, 0, maximums[2]);
        stack.add(root);
        int[][] possibilities = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };

        while (!stack.empty()) {
            Node current = stack.pop();
            if (current.volumes[0] == 0 && !options.contains(current.volumes[2])) {
                options.add(current.volumes[2]);
            }
            check[current.volumes[0]][current.volumes[1]][current.volumes[2]] = true;
            for (int i = 0; i < 6; i++) {
                Node newNode = current.pour(current, possibilities[i][0], possibilities[i][1],
                        maximums[possibilities[i][1]]);
                if (!check[newNode.volumes[0]][newNode.volumes[1]][newNode.volumes[2]]) {
                    stack.push(newNode);
                }
            }
        }
        Collections.sort(options);
        String output = "";
        for (int i = 0; i < options.size(); i++) {
            if (i != options.size() - 1) {
                output += options.get(i) + " ";
            } else {
                output += options.get(i);
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        pw.println(output);
        pw.close();

    }
}

class Node {
    public int[] volumes = new int[3];

    public Node(int v1, int v2, int v3) {
        volumes[0] = v1;
        volumes[1] = v2;
        volumes[2] = v3;
    }

    public Node(Node n) {
        this.volumes[0] = n.volumes[0];
        this.volumes[1] = n.volumes[1];
        this.volumes[2] = n.volumes[2];
    }

    public Node pour(Node n, int from, int into, int cap) {
        Node n2 = new Node(n);

        int amount;

        if (n2.volumes[into] + n2.volumes[from] > cap) {
            amount = cap - n2.volumes[into];
        } else {
            amount = n2.volumes[from];
        }

        n2.volumes[from] -= amount;
        n2.volumes[into] += amount;

        return n2;
    }

    public String toString() {
        return "Volumes: " + volumes[0] + ", " + volumes[1] + ", " + volumes[2];
    }
}
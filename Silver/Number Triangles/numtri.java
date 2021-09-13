/*
ID:
LANG: java
TASK: numtri
*/

import java.util.*;
import java.io.*;

class numtri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        int length = Integer.parseInt(br.readLine());
        int[][] triangle = new int[length][length];

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                int num1 = triangle[i + 1][j];
                int num2 = triangle[i + 1][j + 1];
                int max = Math.max(num1, num2);
                triangle[i][j] += max;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        pw.println(triangle[0][0]);
        pw.close();
    }
}
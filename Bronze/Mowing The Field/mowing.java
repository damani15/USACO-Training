import java.util.*;
import java.io.*;

class mowing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        int[][] grid = new int[2001][2001];
        for (int i = 0; i < 2001; i++) {
            for (int z = 0; z < 2001; z++) {
                grid[i][z] = -1;
            }
        }
        int lines = Integer.parseInt(br.readLine());
        int max = 2001;
        int x = 1000;
        int y = 1000;
        int movex = 0;
        int movey = 0;
        int time = 0;

        grid[x][y] = 0;
        StringTokenizer st;

        for (int i = 0; i < lines; i++) {
            movey = 0;
            movex = 0;
            st = new StringTokenizer(br.readLine());
            String cardinal = st.nextToken();
            if (cardinal.equals("N")) {
                movey = 1;
            } else if (cardinal.equals("S")) {
                movey = -1;
            } else if (cardinal.equals("W")) {
                movex = -1;
            } else if (cardinal.equals("E")) {
                movex = 1;
            }
            int distance = Integer.parseInt(st.nextToken());

            for (int z = 0; z < distance; z++) {
                x += movex;
                y += movey;
                time++;
                if (time - grid[x][y] < max && grid[x][y] >= 0) {
                    max = time - grid[x][y];
                }
                grid[x][y] = time;
            }
        }
        br.close();
        if (max == 2001) {
            max = -1;
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        pw.println(max);
        pw.close();

    }
}
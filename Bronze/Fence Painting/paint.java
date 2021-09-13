import java.util.*;
import java.io.*;

class paint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        int a = 0, b = 0, c = 0, d = 0;
        int[] painted = new int[100];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
            } else {
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        boolean fill = false;

        for (int i = 0; i < painted.length; i++) {
            if (i == a) {
                fill = true;
            }
            if (fill) {
                painted[i] = 1;
            }
            if (i == b - 1) {
                fill = false;
            }
        }

        fill = false;

        for (int i = 0; i < painted.length; i++) {
            if (i == c) {
                fill = true;
            }
            if (fill) {
                painted[i] = 1;
            }
            if (i == d - 1) {
                fill = false;
            }
        }

        int counter = 0;

        for (int i = 0; i < painted.length; i++) {
            if (painted[i] == 1) {
                counter++;
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        pw.println(counter);
        pw.close();
    }
}
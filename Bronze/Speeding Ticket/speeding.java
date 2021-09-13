import java.util.*;
import java.io.*;

class speeding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] limits = new int[100];
        int[] speed = new int[100];
        int duration = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int newDuration = Integer.parseInt(st.nextToken());
            int speedLimit = Integer.parseInt(st.nextToken());
            for (int z = duration; z < newDuration + duration; z++) {
                limits[z] = speedLimit;
            }
            duration += newDuration;
        }

        duration = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int newDuration = Integer.parseInt(st.nextToken());
            int speedActual = Integer.parseInt(st.nextToken());
            for (int z = duration; z < newDuration + duration; z++) {
                speed[z] = speedActual;
            }
            duration += newDuration;
        }
        br.close();

        int maxDiff = 0;
        for (int i = 0; i < 100; i++) {
            if (speed[i] - limits[i] > maxDiff) {
                maxDiff = speed[i] - limits[i];
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        pw.println(maxDiff);
        pw.close();
    }
}
import java.util.*;
import java.io.*;

class balancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCows = Integer.parseInt(st.nextToken());

        int[] xValues = new int[numCows];
        int[] yValues = new int[numCows];

        for (int i = 0; i < numCows; i++) {
            st = new StringTokenizer(br.readLine());
            xValues[i] = Integer.parseInt(st.nextToken());
            yValues[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int leastCows = numCows;

        for (int i = 0; i < numCows; i++) {
            int div1 = xValues[i] + 1;
            for (int j = 0; j < numCows; j++) {
                int div2 = yValues[j] + 1;

                int[] totalCows = new int[4];
                for (int z = 0; z < numCows; z++) {
                    if (xValues[z] < div1 && yValues[z] < div2) {
                        totalCows[0]++;
                    } else if (xValues[z] < div1 && yValues[z] > div2) {
                        totalCows[1]++;
                    } else if (xValues[z] > div1 && yValues[z] < div2) {
                        totalCows[2]++;
                    } else {
                        totalCows[3]++;
                    }
                }

                int temp = totalCows[0];
                for (int z = 1; z < 4; z++) {
                    if (totalCows[z] > temp) {
                        temp = totalCows[z];
                    }
                }

                if (temp < leastCows) {
                    leastCows = temp;
                }
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        pw.println(leastCows);
        pw.close();

    }
}
import java.util.*;
import java.io.*;

class cowdance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCows = Integer.parseInt(st.nextToken());
        int targetTime = Integer.parseInt(st.nextToken());
        int[] cows = new int[numCows];

        for (int i = 0; i < numCows; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int small = 1;
        int large = cows.length;
        int middle = 0;

        while (small < large) {
            middle = (int) ((small + large) / 2);
            int tempTime = danceTime(cows, middle);
            if (tempTime <= targetTime) {
                large = middle;
            } else {
                small = middle + 1;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        pw.println(middle);
        pw.close();
    }

    public static int danceTime(int[] cows, int size) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < size; i++) {
            pq.add(cows[i]);
        }
        for (int i = size; i < cows.length; i++) {
            int num = pq.poll();
            pq.add(num + cows[i]);
        }

        int answer = pq.poll();
        for (int i = 0; i < pq.size(); i++) {
            answer = Math.max(answer, pq.poll());
        }
        return answer;
    }
}
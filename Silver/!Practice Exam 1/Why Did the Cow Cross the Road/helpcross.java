import java.util.*;
import java.io.*;

class helpcross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numChickens = Integer.parseInt(st.nextToken());
        int numCows = Integer.parseInt(st.nextToken());
        Animal[] animalTimes = new Animal[numCows + numChickens];

        for (int i = 0; i < numChickens; i++) {
            int x = Integer.parseInt(br.readLine());
            animalTimes[i] = new Animal(x, x, false);
        }

        for (int i = numChickens; i < numChickens + numCows; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animalTimes[i] = new Animal(x, y, true);
        }

        Arrays.sort(animalTimes);

        System.out.println(Arrays.toString(animalTimes));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int numPairs = 0;
        int index = 0;
        for (int i = 0; i < numChickens + numCows; i++) {

            if (pq.size() > 0) {

            }
        }
    }
}

class Animal implements Comparable<Animal> {
    int startTime;
    int endTime;
    boolean cow;

    public Animal(int x, int y, boolean c) {
        startTime = x;
        endTime = y;
        cow = c;
    }

    public String toString() {
        if (cow)
            return "Start: " + startTime + " End: " + endTime;
        else
            return startTime + "";
    }

    public int compareTo(Animal other) {
        if (this.startTime != other.startTime) {
            return this.startTime - other.startTime;
        }
        if (this.cow && !other.cow) {
            return -1;
        }
        if (!this.cow && other.cow) {
            return 1;
        }
        return 0;
    }
}
import java.util.*;
import java.io.*;

class moocast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        int n = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        br.close();

        boolean[] visited = new boolean[n];

        int max = 0;
        for (int i = 0; i < cows.length; i++) {
            visited = new boolean[n];
            visited[i] = true;
            int tempMax = DFS(cows[i], cows, visited);
            if (tempMax > max) {
                max = tempMax;
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        pw.println(max);
        pw.close();

    }

    public static int DFS(Cow start, Cow[] cows, boolean[] visited) {
        Stack<Cow> stack = new Stack<Cow>();

        stack.push(start);
        int totalCows = 0;

        while (!stack.isEmpty()) {
            Cow currentCow = stack.pop();
            totalCows++;

            int cowPow = currentCow.power;
            for (int i = 0; i < cows.length; i++) {
                if (!visited[i]) {
                    double dist = Math  
                            .sqrt(Math.pow(currentCow.x - cows[i].x, 2) + Math.pow(currentCow.y - cows[i].y, 2));
                    if (dist <= cowPow) {
                        stack.add(cows[i]);
                        visited[i] = true;
                    }
                }
            }
        }

        return totalCows;
    }
}

class Cow {
    int x;
    int y;
    int power;

    Cow(int x, int y, int p) {
        this.x = x;
        this.y = y;
        power = p;
    }

    public String toString() {
        return x + " " + y + " " + power;
    }
}
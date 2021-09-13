/*
ID: your_id_here
LANG: JAVA
TASK: lostcow
*/

import java.util.*;
import java.io.*;

class lostcow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int max = 9 * Math.abs(x - y);
        int totalDistance = 0;
        int previousLocation = x;

        for (int i = 0; i < max; i++) {
            int newLocation = x + (int) Math.pow(-2, i);

            if ((y <= x && newLocation <= y) || (y >= x && newLocation >= y)) {
                totalDistance += Math.abs(previousLocation - y);
                break;
            }
            totalDistance += Math.abs(newLocation - previousLocation);
            previousLocation = newLocation;
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        pw.println(totalDistance);
        pw.close();

    }
}
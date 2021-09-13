/*
    ID:
    LANG: JAVA
    TASK: ariprog
*/

import java.util.*;
import java.io.*;

class ariprog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        int numTerms = Integer.parseInt(br.readLine());
        int limit = Integer.parseInt(br.readLine());
        br.close();

        boolean[] possibilities = new boolean[limit * limit * 2 + 1];
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                possibilities[i * i + j * j] = true;
            }
        }

        HashMap<Integer, Integer> answers = new HashMap<Integer, Integer>();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        for (int i = 0; i < possibilities.length - 1; i++) {
            for (int j = 1; j < (possibilities.length - 1 - i) / (numTerms - 1) + 1; j++) {
                boolean check = true;
                for (int z = 0; z < numTerms; z++) {
                    int num = i + z * j;
                    if (!possibilities[num]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answers.put(i, j);
                }
            }
        }

        HashMap<Integer, Integer> sorted = new HashMap<Integer, Integer>();
        for (Integer i : answers.keySet()) {
            int lowest = answers.get(i);
            int low = i;
            for (Integer j : answers.keySet()) {
                if (answers.get(j) < lowest) {
                    lowest = answers.get(j);
                    low = j;
                }
            }
            sorted.put(low, lowest);
        }
        for (Integer i : sorted.keySet()) {
            pw.println(i + " " + sorted.get(i));
        }
        pw.close();

    }
}
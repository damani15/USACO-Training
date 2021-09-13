/*
ID:
LANG: JAVA
TASK: pprime
*/

import java.util.*;
import java.io.*;

class pprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int low = Integer.parseInt(st.nextToken());
        int high = Integer.parseInt(st.nextToken());
        br.close();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        int numLowDigits = Integer.toString(low).length();
        int numHighDigits = Integer.toString(high).length();
        for (int i = numLowDigits; i <= numHighDigits; i++) {
            if (i == 1) {
                if (low <= 5) {
                    pw.println(5);
                }
                if (high >= 7) {
                    pw.println(7);
                }
            }
            if (i == 2) {
                for (int j = 1; j <= 9; j += 2) {
                    int num = Integer.parseInt(j + "" + j);
                    if (high >= num && low <= num && isPrime(num)) {
                        pw.println(num);
                    }
                }
            }
            if (i == 3) {
                for (int j = 1; j <= 9; j += 2) {
                    for (int z = 0; z <= 9; z++) {
                        int num = Integer.parseInt(j + "" + z + "" + j);
                        if (high >= num && low <= num && isPrime(num)) {
                            pw.println(num);
                        }
                    }
                }
            }
            if (i == 4) {
                for (int j = 1; j <= 9; j += 2) {
                    for (int z = 0; z <= 9; z++) {
                        int num = Integer.parseInt(j + "" + z + "" + z + "" + j);
                        if (high >= num && low <= num && isPrime(num)) {
                            pw.println(num);
                        }
                    }
                }
            }
            if (i == 5) {
                for (int j = 1; j <= 9; j += 2) {
                    for (int z = 0; z <= 9; z++) {
                        for (int y = 0; y <= 9; y++) {
                            int num = Integer.parseInt(j + "" + z + "" + y + "" + z + "" + j);
                            if (high >= num && low <= num && isPrime(num)) {
                                pw.println(num);
                            }
                        }
                    }
                }
            }
            if (i == 6) {
                for (int j = 1; j <= 9; j += 2) {
                    for (int z = 0; z <= 9; z++) {
                        for (int y = 0; y <= 9; y++) {
                            int num = Integer.parseInt(j + "" + z + "" + y + "" + y + "" + z + "" + j);
                            if (high >= num && low <= num && isPrime(num)) {
                                pw.println(num);
                            }
                        }
                    }
                }
            }
            if (i == 7) {
                for (int j = 1; j <= 9; j += 2) {
                    for (int z = 0; z <= 9; z++) {
                        for (int y = 0; y <= 9; y++) {
                            for (int u = 0; u <= 9; u++) {
                                int num = Integer.parseInt(j + "" + z + "" + y + "" + u + "" + y + "" + z + "" + j);
                                if (high >= num && low <= num && isPrime(num)) {
                                    pw.println(num);
                                }
                            }
                        }
                    }
                }
            }
            if (i == 8) {
                for (int j = 1; j <= 9; j += 2) {
                    for (int z = 0; z <= 9; z++) {
                        for (int y = 0; y <= 9; y++) {
                            for (int u = 0; u <= 9; u++) {
                                int num = Integer
                                        .parseInt(j + "" + z + "" + y + "" + u + "" + u + "" + y + "" + z + "" + j);
                                if (high >= num && low <= num && isPrime(num)) {
                                    pw.println(num);
                                }
                            }
                        }
                    }
                }
            }
        }
        pw.close();
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
ID:
LANG: JAVA
TASK: sprime
*/

import java.util.*;
import java.io.*;

public class sprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
        int numDigits = Integer.parseInt(br.readLine());
        br.close();

        ArrayList<Integer> nums = new ArrayList<Integer>();
        generate(2, numDigits, nums);
        for (int i = 3; i < 8; i += 2) {
            generate(i, numDigits, nums);
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        for (Integer i : nums) {
            pw.println(i);
        }
        pw.close();
    }

    public static void generate(int num, int max, ArrayList<Integer> nums) {
        if (Integer.toString(num).length() == max && isPrime(num)) {
            nums.add(num);
        }
        if (isPrime(num)) {
            for (int i = 1; i < 10; i += 2) {
                generate(Integer.parseInt(Integer.toString(num) + Integer.toString(i)), max, nums);
            }
        }

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
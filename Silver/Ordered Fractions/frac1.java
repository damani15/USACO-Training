/*
ID: 1235
LANG: JAVA
TASK: frac1
*/

import java.util.*;
import java.io.*;

class frac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        int num = Integer.parseInt(br.readLine());
        br.close();

        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        fractions.add(new Fraction(0, 1));
        fractions.add(new Fraction(1, 1));
        for (int i = num; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                fractions.add(new Fraction(j, i));
            }
        }

        ArrayList<Integer> spots = new ArrayList<Integer>();
        System.out.println(Arrays.toString(fractions.toArray()));

        for (int i = 2; i < fractions.size(); i++) {
            for (int j = 2; j <= fractions.get(i).numerator; j++) {
                if (fractions.get(i).numerator % j == 0 && fractions.get(i).denominator % j == 0) {
                    spots.add(i);
                }
            }
        }

        for (int i = spots.size() - 1; i >= 0; i--) {
            fractions.remove((int) spots.get(i));
        }
        System.out.println(Arrays.toString(fractions.toArray()));

        Collections.sort(fractions);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        for (Fraction f : fractions) {
            pw.println(f.toString());
        }
        pw.close();

    }
}

class Fraction implements Comparable<Fraction> {

    public int numerator;
    public int denominator;

    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public double convertToDecimal() {
        return (double) numerator / (double) denominator;
    }

    public int compareTo(Fraction other) {
        double val = this.convertToDecimal();
        double otherVal = other.convertToDecimal();
        if (val > otherVal) {
            return 1;
        } else if (otherVal > val) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
import java.util.*;
import java.io.*;

class haybales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        StringTokenizer line1 = new StringTokenizer(br.readLine());

        int numBales = Integer.parseInt(line1.nextToken());
        int numLines = Integer.parseInt(line1.nextToken());
        int[] bales = new int[numBales];

        line1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < numBales; i++) {
            bales[i] = Integer.parseInt(line1.nextToken());
        }

        Arrays.sort(bales);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

        for (int i = 0; i < numLines; i++) {
            line1 = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(line1.nextToken());
            int end = Integer.parseInt(line1.nextToken());

            int num1 = modifiedBinary(bales, end);
            int num2 = modifiedBinary(bales, start - 1);

            pw.println(num1 - num2);

        }

        br.close();
        pw.close();
        // doesnt work

    }

    public static int modifiedBinary(int[] bales, int lim) {
        int min = 0;
        int max = bales.length - 1;

        while (min <= max) {
            int middle = (min + max) / 2;
            if (bales[middle] <= lim) {
                min = middle;
            } else {
                max = middle - 1;
            }
        }
        return min + 1;
    }
}
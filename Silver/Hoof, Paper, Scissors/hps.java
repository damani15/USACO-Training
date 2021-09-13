import java.util.*;
import java.io.*;

class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        int n = Integer.parseInt(br.readLine());

        int[] numHooves = new int[n + 1];
        int[] numPapers = new int[n + 1];
        int[] numScissors = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            numHooves[i] = numHooves[i - 1];
            numPapers[i] = numPapers[i - 1];
            numScissors[i] = numScissors[i - 1];
            switch (br.readLine()) {
                case "P":
                    numPapers[i]++;
                    break;
                case "S":
                    numScissors[i]++;
                    break;
                case "H":
                    numHooves[i]++;
                    break;
            }
        }
        br.close();

        int totalMax = 0;

        for (int i = 1; i < n + 1; i++) {
            int max1 = Math.max(numHooves[i], numPapers[i]);
            max1 = Math.max(numScissors[i], max1);

            int max2 = Math.max(numHooves[n] - numHooves[i], numPapers[n] - numPapers[i]);
            max2 = Math.max(numScissors[n] - numScissors[i], max2);

            totalMax = Math.max(totalMax, max1 + max2);
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        pw.println(totalMax);
        pw.close();
    }
}
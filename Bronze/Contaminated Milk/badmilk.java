import java.util.*;
import java.io.*;

class badmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
        ArrayList<int[]> milkLogs = new ArrayList<int[]>();
        ArrayList<int[]> sickLogs = new ArrayList<int[]>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numPeople = Integer.parseInt(st.nextToken());
        int numMilk = Integer.parseInt(st.nextToken());
        int numLogs = Integer.parseInt(st.nextToken());
        int numSickLogs = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numLogs; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] addition = { a, b, c };
            milkLogs.add(addition);
        }
        for (int i = 0; i < numSickLogs; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] addition = { a, b };
            sickLogs.add(addition);
        }
        br.close();

        ArrayList<Integer> potentialMilk = new ArrayList<Integer>();

        for (int i = 0; i < numSickLogs; i++) {
            int person = sickLogs.get(i)[0];
            int time = sickLogs.get(i)[1];
            for (int z = 0; z < numLogs; z++) {
                if (milkLogs.get(z)[0] == person && milkLogs.get(z)[2] < time) {
                    boolean add = true;
                    for (Integer j : potentialMilk) {
                        if (j == milkLogs.get(z)[1]) {
                            add = false;
                        }
                    }
                    if (add) {
                        potentialMilk.add(milkLogs.get(z)[1]);
                    }
                }
            }
        }

        for (int i = 0; i < numSickLogs; i++) {
            int person = sickLogs.get(i)[0];
            for (int z = 0; z < potentialMilk.size(); z++) {
                boolean keep = false;
                for (int j = 0; j < numLogs; j++) {
                    if (milkLogs.get(j)[0] == person) {
                        if (milkLogs.get(j)[1] == potentialMilk.get(z) && milkLogs.get(j)[2] < sickLogs.get(i)[1]) {
                            keep = true;
                            break;
                        }
                    }
                }
                if (!keep) {
                    potentialMilk.remove(z);
                }
            }
        }

        int numDoses = 0;
        ArrayList<Integer> affected = new ArrayList<Integer>();
        for (int i = 0; i < potentialMilk.size(); i++) {
            for (int j = 0; j < numLogs; j++) {
                if (potentialMilk.get(i) == milkLogs.get(j)[1]) {
                    boolean add = true;
                    for (Integer z : affected) {
                        if (z == milkLogs.get(j)[0]) {
                            add = false;
                        }
                    }
                    if (add) {
                        numDoses++;
                        affected.add(milkLogs.get(j)[0]);
                    }
                }
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        pw.println(numDoses);
        pw.close();

    }
}
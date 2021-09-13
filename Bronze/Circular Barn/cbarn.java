import java.io.*;

class cbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        int rooms = Integer.parseInt(br.readLine());
        int totalCows = 0;
        int[] requiredCows = new int[rooms];
        for (int i = 0; i < rooms; i++) {
            int temp = Integer.parseInt(br.readLine());
            totalCows += temp;
            requiredCows[i] = temp;
        }
        br.close();
        int minDistance = 100000000;
        for (int i = 0; i < rooms; i++) {
            int tempDistance = 0;
            int tempTotalCows = totalCows;
            for (int j = i; j < i + rooms; j++) {
                tempTotalCows -= requiredCows[j % rooms];
                tempDistance += tempTotalCows;
            }
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        pw.println(minDistance);
        pw.close();
    }
}
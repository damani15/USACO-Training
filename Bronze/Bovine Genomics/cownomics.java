import java.util.*;
import java.io.*;

class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numStrings = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        String[][] genomes = new String[2][numStrings];

        for (int i = 0; i < 2; i++) {
            for (int z = 0; z < numStrings; z++) {
                genomes[i][z] = br.readLine();
            }
        }
        br.close();

        boolean unique = false;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            unique = true;
            for (int j = 0; j < numStrings; j++) {
                char currentCharacter = genomes[0][j].charAt(i);

                for (int z = 0; z < numStrings; z++) {
                    if (currentCharacter == genomes[1][z].charAt(i)) {
                        unique = false;
                        break;
                    }
                }
                if (!unique) {
                    break;
                }
            }
            if (unique) {
                counter++;
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        pw.println(counter);
        pw.close();
    }
}
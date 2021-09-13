import java.util.*;
import java.io.*;

class cowcode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        long index = Integer.parseInt(st.nextToken())-1;
        br.close();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));

        if (index <= word.length()) {
            pw.println(word.charAt((int) (index - 1)));
        } else {
            long numRotations = index / (long) word.length();
            System.out.println(numRotations);

            long place = (index % (long) word.length());
            System.out.println(place);

            long actualRotations = (numRotations) % (long) word.length();
            System.out.println(actualRotations);

        }

    }
}
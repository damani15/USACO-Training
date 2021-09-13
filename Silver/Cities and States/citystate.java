import java.util.*;
import java.io.*;

class citystate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        int numCities = Integer.parseInt(br.readLine());
        HashMap<String, Integer> cityStates = new HashMap<String, Integer>();

        for (int i = 0; i < numCities; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String city = st.nextToken().substring(0, 2);
            String state = st.nextToken();
            String cs = city + state;
            if (cityStates.containsKey(cs)) {
                cityStates.put(cs, cityStates.get(cs) + 1);
            } else {
                if (!city.equals(state))
                    cityStates.put(cs, 1);
            }
        }
        br.close();

        /*
         * for (Map.Entry<String, Integer> s : cityStates.entrySet()) {
         * System.out.println(s.getKey() + " " + s.getValue()); }
         */

        int numSpecial = 0;
        for (Map.Entry<String, Integer> s : cityStates.entrySet()) {
            String currentKey = s.getKey();
            String pair = currentKey.substring(2) + currentKey.substring(0, 2);
            if (cityStates.containsKey(pair)) {
                numSpecial += cityStates.get(currentKey) * cityStates.get(pair);
            }
        }
        // System.out.println(numSpecial / 2);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        pw.println(numSpecial / 2);
        pw.close();
    }
}
import java.util.*;
import java.io.*;

class art {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("art.in"));
        int dimension = Integer.parseInt(br.readLine());
        int[][] canvas = new int[dimension][dimension];
        ArrayList<Integer> uniqueColors = new ArrayList<Integer>();

        for (int i = 0; i < dimension; i++) {
            String line = br.readLine();
            for (int j = 0; j < dimension; j++) {
                int addition = Character.getNumericValue(line.charAt(j));
                canvas[i][j] = addition;
                int length = uniqueColors.size();
                int counter = 0;
                for (Integer z : uniqueColors) {
                    if (z == addition) {
                        break;
                    }
                    counter++;
                }
                if (counter == length) {
                    if (addition != 0) {
                        uniqueColors.add(addition);

                        uniqueColors.add(addition % 2);
                    }
                }

            }
        }
        br.close();

        int[][] coordinates = new int[uniqueColors.size()][4];

        for (int i = 0; i < uniqueColors.size(); i++) {
            int topMost = dimension;
            int leftMost = dimension;
            int bottomMost = 0;
            int rightMost = 0;
            for (int j = 0; j < canvas.length; j++) {
                for (int z = 0; z < canvas.length; z++) {
                    if (canvas[j][z] == uniqueColors.get(i)) {
                        if (j < topMost) {
                            topMost = j;
                        }
                        if (z < leftMost) {
                            leftMost = z;
                        }
                        if (j > bottomMost) {
                            bottomMost = j;
                        }
                        if (z > rightMost) {
                            rightMost = z;
                        }
                    }
                }
            }
            coordinates[i][0] = leftMost;
            coordinates[i][1] = topMost;
            coordinates[i][2] = rightMost;
            coordinates[i][3] = bottomMost;
        }

        System.out.println(Arrays.deepToString(coordinates));

    }
}
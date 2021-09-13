import java.util.*;
import java.io.*;

class angry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        int length = Integer.parseInt(br.readLine());
        int[] cows = new int[length];
        for (int i = 0; i < length; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(cows);
        int max = 0;
        for (int i = 0; i < length; i++) {
            int leftPos = findExtreme(cows, -1, i);
            int rightPos = findExtreme(cows, 1, i);
            int barrelsExploded = rightPos - leftPos + 1;
            if (barrelsExploded > max) {
                max = barrelsExploded;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        pw.println(max);
        pw.close();
    }

    public static int findExtreme(int[] arr, int direction, int startPos) {
        int lastPos = startPos;
        int radius = 1;
        if (direction == -1) {
            while (lastPos > 0) {
                int nextPos = lastPos;
                while ((nextPos + direction >= 0) && (Math.abs(arr[nextPos + direction] - arr[lastPos]) <= radius)) {
                    nextPos += direction;
                }
                if (nextPos == lastPos) {
                    break;
                }
                lastPos = nextPos;
                radius++;
            }
        } else {
            while (lastPos < arr.length - 1) {
                int nextPos = lastPos;
                while ((nextPos + direction < arr.length)
                        && (Math.abs(arr[nextPos + direction] - arr[lastPos]) <= radius)) {
                    nextPos += direction;
                }
                if (nextPos == lastPos) {
                    break;
                }
                lastPos = nextPos;
                radius++;
            }
        }
        return lastPos;
    }
}
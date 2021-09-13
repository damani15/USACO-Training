import java.util.*;

class abcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] combos = new int[7];
        for (int i = 0; i < 7; i++) {
            combos[i] = (sc.nextInt());
        }
        sc.close();

        Arrays.sort(combos);

        int A = combos[0];
        int B = combos[1];
        int max = combos[6];
        int C = max - A - B;
        System.out.println(A + " " + B + " " + C);
    }
}
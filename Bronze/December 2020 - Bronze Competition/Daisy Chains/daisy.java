import java.util.*;

class daisy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numFlowers = sc.nextInt();
        int[] petalCount = new int[numFlowers];
        for (int i = 0; i < numFlowers; i++) {
            petalCount[i] = sc.nextInt();
        }
        sc.close();

        int answer = numFlowers;
        for (int i = 0; i < numFlowers - 1; i++) {
            for (int j = i + 1; j < numFlowers; j++) {
                int sum = 0;
                for (int z = i; z <= j; z++) {
                    sum += petalCount[z];
                }
                float total = j - i + 1;
                float average = sum / total;
                for (int z = i; z <= j; z++) {
                    if (petalCount[z] == average) {
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
import java.util.*;

class stuck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCows = sc.nextInt();
        int[] grass = new int[numCows];
        String[] directions = new String[numCows];
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> stoppedCows = new ArrayList<Integer>();
        for (int i = 0; i < numCows; i++) {
            directions[i] = sc.next();
            ArrayList<Integer> tempx = new ArrayList<Integer>();
            tempx.add(sc.nextInt());
            ArrayList<Integer> tempy = new ArrayList<Integer>();
            tempy.add(sc.nextInt());
            x.add(tempx);
            y.add(tempy);
        }
        sc.close();

        for (int i = 0; i < numCows; i++) {
            grass[i] = 1;
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < numCows; j++) {
                boolean stopped = false;
                for (int z = 0; z < stoppedCows.size(); z++) {
                    if (stoppedCows.get(z) == j) {
                        stopped = true;
                        break;
                    }
                }
                if (stopped) {
                    continue;
                }
                String direction = directions[j];
                int xCoord = x.get(j).get(x.get(j).size() - 1);
                int yCoord = y.get(j).get(y.get(j).size() - 1);
                if (direction.equals("N")) {
                    yCoord++;
                } else {
                    xCoord++;
                }
                y.get(j).add(yCoord);
                x.get(j).add(xCoord);
            }

            for (int j = 0; j < numCows; j++) {
                boolean stopped = false;
                for (int z = 0; z < stoppedCows.size(); z++) {
                    if (stoppedCows.get(z) == j) {
                        stopped = true;
                        break;
                    }
                }
                if (stopped) {
                    continue;
                }
                int xCoord = x.get(j).get(x.get(j).size() - 1);
                int yCoord = y.get(j).get(y.get(j).size() - 1);
                // other cows positions
                checkLoop: for (int z = 0; z < numCows; z++) {
                    // don't check against self
                    if (z != j) {
                        for (int p = 0; p < x.get(z).size() - 1; p++) {
                            // if x coordinates are the same
                            if (xCoord == x.get(z).get(p)) {
                                for (int w = 0; w < y.get(z).size() - 1; w++) {
                                    if (yCoord == y.get(z).get(w)) {
                                        stopped = true;
                                        break checkLoop;
                                    }
                                }
                            }
                        }
                    }
                }
                if (stopped)
                    stoppedCows.add(j);
            }
            for (int j = 0; j < numCows; j++) {
                boolean stopped = false;
                for (int z = 0; z < stoppedCows.size(); z++) {
                    if (stoppedCows.get(z) == j) {
                        stopped = true;
                        break;
                    }
                }
                if (stopped) {
                    continue;
                }
                grass[j]++;
            }
        }
        for (int i = 0; i < grass.length; i++) {
            if (grass[i] > 1000) {
                System.out.println("Infinity");
            } else {
                System.out.println(grass[i]);
            }
        }
    }
}
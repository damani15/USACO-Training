/*
ID: A
LANG: JAVA
TASK: castle
*/

import java.util.*;
import java.io.*;

class castle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("castle.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int columns = Integer.parseInt(st.nextToken());
        int rows = Integer.parseInt(st.nextToken());
        Module[][] grid = new Module[rows][columns];
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Module(Integer.parseInt(st.nextToken()));
            }
        }
        br.close();

        ArrayList<Integer> roomSizes = new ArrayList<Integer>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // first part
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j]) {
                    roomSizes.add(floodfill(grid, i, j, visited));
                }
            }
        }
        Collections.sort(roomSizes);
        System.out.println(Arrays.toString(roomSizes.toArray()));

        // second part
        int max = 0;
        int x = 0;
        int y = rows - 1;
        String dir = "";
        for (int i = 0; i < columns; i++) {
            for (int j = rows - 1; j >= 0; j--) {
                visited = new boolean[grid.length][grid[0].length];
                int tempMax = 0;
                if (grid[j][i].north && j != 0) {
                    grid[j][i].north = false;
                    grid[j - 1][i].south = false;
                    tempMax = floodfill(grid, j, i, visited);
                    grid[j][i].north = true;
                    grid[j - 1][i].south = true;
                }
                if (tempMax > max) {
                    max = tempMax;
                    dir = "N";
                    x = j + 1;
                    y = i + 1;
                }
                visited = new boolean[grid.length][grid[0].length];
                if (grid[j][i].east && i != columns - 1) {
                    grid[j][i].east = false;
                    grid[j][i + 1].west = false;
                    tempMax = floodfill(grid, j, i, visited);
                    grid[j][i].east = true;
                    grid[j][i + 1].west = true;
                }
                if (tempMax > max) {
                    max = tempMax;
                    dir = "E";
                    x = j + 1;
                    y = i + 1;
                }
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        pw.println(roomSizes.size());
        pw.println(roomSizes.get(roomSizes.size() - 1));
        pw.println(max);
        pw.println(x + " " + y + " " + dir);
        pw.close();
    }

    public static int floodfill(Module[][] grid, int startPointX, int startPointY, boolean[][] visited) {
        Module start = grid[startPointX][startPointY];

        int[] current = { startPointX, startPointY };
        visited[startPointX][startPointY] = true;
        Stack<int[]> coords = new Stack<int[]>();
        coords.push(current);

        int count = 0;

        while (!coords.isEmpty()) {
            current = coords.pop();
            int x = current[0];
            int y = current[1];

            count++;
            start = grid[x][y];

            if (!start.east && !visited[x][y + 1]) {
                int[] test = { x, y + 1 };
                coords.push(test);
                visited[x][y + 1] = true;
            }

            if (!start.west && !visited[x][y - 1]) {
                int[] test = { x, y - 1 };
                coords.push(test);
                visited[x][y - 1] = true;
            }
            if (!start.north && !visited[x - 1][y]) {
                int[] test = { x - 1, y };
                coords.push(test);
                visited[x - 1][y] = true;
            }
            if (!start.south && !visited[x + 1][y]) {
                int[] test = { x + 1, y };
                coords.push(test);
                visited[x + 1][y] = true;
            }
        }

        return count;
    }
}

class Module {
    boolean west;
    boolean north;
    boolean east;
    boolean south;

    public Module(int x) {
        if (x / 8 >= 1) {
            south = true;
            x -= 8;
        }
        if (x / 4 >= 1) {
            east = true;
            x -= 4;
        }
        if (x / 2 >= 1) {
            north = true;
            x -= 2;
        }
        if (x == 1) {
            west = true;
        }
    }

    public String toString() {
        return "West: " + west + "\nEast: " + east + "\nNorth: " + north + "\nSouth: " + south;
    }
}
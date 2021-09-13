/*
    ID:
    LANG: JAVA
    TASK: mootube
*/

import java.util.*;
import java.io.*;

class mootube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numVideos = Integer.parseInt(st.nextToken());
        int numQuestions = Integer.parseInt(st.nextToken());

        Node[] videos = new Node[numVideos];
        for (int i = 0; i < numVideos; i++) {
            videos[i] = new Node(i + 1);
        }
        for (int i = 0; i < numVideos - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int video1 = Integer.parseInt(st.nextToken());
            int video2 = Integer.parseInt(st.nextToken());
            int relevance = Integer.parseInt(st.nextToken());
            videos[video1 - 1].connections.add(new Edge(video2, relevance));
            videos[video2 - 1].connections.add(new Edge(video1, relevance));
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        for (int i = 0; i < numQuestions; i++) {
            st = new StringTokenizer(br.readLine());
            int currentRel = Integer.parseInt(st.nextToken());
            int currentVideo = Integer.parseInt(st.nextToken());
            pw.println(BFS(videos[currentVideo - 1], currentRel, numVideos, videos));
        }

        br.close();
        pw.close();
    }

    public static int BFS(Node root, int min, int numVideos, Node[] nodes) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        boolean[] checked = new boolean[numVideos];
        int count = 0;

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            count++;
            checked[current.id - 1] = true;

            for (Edge e : current.connections) {
                if (!checked[e.to - 1] && e.relevance >= min) {
                    queue.add(nodes[e.to - 1]);
                    checked[e.to - 1] = true;
                }
            }
        }

        return count - 1;
    }
}

class Edge {

    public int to;
    public int relevance;

    public Edge(int to, int relevance) {
        this.to = to;
        this.relevance = relevance;
    }
}

class Node {

    public int id;
    public List<Edge> connections;

    public Node(int id) {
        this.id = id;
        connections = new ArrayList<Edge>();
    }

}
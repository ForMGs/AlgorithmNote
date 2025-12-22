package BfsDfs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class test_bjf02 {
    static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(bfs(start, end));
    }

    static int bfs(int start, int end) {
        if (start == end) return 0;

        boolean[] visited = new boolean[MAX + 1];
        int[] dist = new int[MAX + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            int[] nexts = {x - 1, x + 1, x * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;
                if (visited[nx]) continue;

                visited[nx] = true;
                dist[nx] = dist[x] + 1;

                if (nx == end) return dist[nx];
                q.offer(nx);
            }
        }
        return -1;
    }
}

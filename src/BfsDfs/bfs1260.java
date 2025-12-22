package BfsDfs;

import java.io.*;
import java.util.*;

public class bfs1260 {
    static int N, M, V;
    static int[][] adj;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');

        for (int i = 1; i <= N; i++) {
            if (adj[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            sb.append(v).append(' ');

            for (int i = 1; i <= N; i++) {
                if (adj[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);

        System.out.print(sb.toString());
    }
}

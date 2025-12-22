package BfsDfs;

import java.util.*;
import java.io.*;

public class Bfs_11724 {

    static int m;
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int count =0;

    public static void main(String[] args)throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //정점
        n = Integer.parseInt(st.nextToken()); //간선

        map  = new int[m+1][m+1];
        visited = new boolean[m+1];

        for(int i= 0; i<n; i ++){
            StringTokenizer s = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());

            map[x][y]=1;
            map[y][x]=1;
        }

        for(int k =1; k <= m; k++){

            if(!visited[k]){
                visited[k]=true;
                bfs(k);
                count++;
            }

        }
        System.out.println(count);
    }

    static void bfs(int a){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0];

            for(int j=1; j<=m; j++){
                if(visited[j]) continue;
                if(map[idx][j]==1){
                    q.offer(new int[]{j});
                    visited[j]=true;
                }
            }
        }
    }
}

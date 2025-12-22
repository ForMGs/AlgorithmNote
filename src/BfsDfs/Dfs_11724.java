package BfsDfs;

import java.util.*;
import java.io.*;

public class Dfs_11724 {

    static int m;
    static int n;
    static boolean[] visited;
    static int count;
    static int[][] map;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[m+1];
        map = new int[m+1][m+1];

        for(int i=0 ; i < n; i++){
            StringTokenizer s = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());
            map[x][y]=1;
            map[y][x]=1;
        }

        for(int z= 1; z<= m; z++){
            if(!visited[z]){
                dfs(z);
                count++;
            }

        }

        System.out.println(count);
    }

    static void dfs(int x ){
        visited[x] = true;

        for(int j=1; j<= m ; j++){

            if(visited[j] || map[x][j] == 0) continue;

            if(map[x][j]==1){
                dfs(j);

            }

        }
    }
}

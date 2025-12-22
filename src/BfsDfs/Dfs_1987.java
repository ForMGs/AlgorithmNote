package BfsDfs;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Dfs_1987 {

    static int m;
    static int n;
    static char[][] map;
    static boolean[] visited;
    static int[] dx = {0 , 1 , 0 , -1};
    static int[] dy = {-1, 0 , 1 , 0 };
    static int ans=0;

    public static void main(String[] args) throws Exception{

        System.out.println(1 << 2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[26];

        for(int i =0 ; i<m; i++){
           String s=  br.readLine();
           for(int j=0; j<n; j++){
               map[i][j] = s.charAt(j);
           }
        }
        visited[map[0][0]-'A']= true;
        dfs(0,0,1);
        System.out.println(ans);

        dfs(0,0,1,1 << (map[0][0] -'A'));


    }
    static void dfs(int x , int y , int depth , int mask){
        ans = Math.max(ans, depth);
        for(int dir=0; dir <4 ; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx>=m || ny <0 || ny>=n  ) continue;
            int nextBit = 1 << (map[nx][ny]-'A');
            if((mask & nextBit)==0){
                dfs(nx,ny,depth+1 , mask|nextBit);

            }
        }
    }


    static void dfs(int x , int y , int depth){

        ans = Math.max(ans, depth);


        for(int dir=0; dir <4 ; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx>=m || ny <0 || ny>=n  ) continue;
            if(visited[map[nx][ny]-'A']) continue;
            visited[map[nx][ny]-'A']= true;
            dfs(nx, ny , depth +1);
            visited[map[nx][ny]-'A']= false;

        }
    }

}

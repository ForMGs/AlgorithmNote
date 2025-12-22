package BfsDfs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class bfs01 {

    static int m ,n;
    static int[][] map;
        static boolean[][] visited;

        static int[] dx = { 0, 1, 0, -1 };
        static int[] dy = { 1, 0, -1, 0 };



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        map = new int[n][m];
        visited =new boolean[n][m];

        for(int i =0; i<n; i++){
            String line = sc.next();
            for(int j=0; j<m; j++){
                map[i][j]= line.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    static void bfs(int x, int y) {

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y]=true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0],cy = cur[1];

            for(int d= 0; d <4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx <0 || ny <0 || nx >=n || ny >=m) continue;
                if(visited[nx][ny] || map[nx][ny]==0) continue;

                visited[nx][ny]=true;
                map[nx][ny] = map[cx][cy] +1;
                q.offer(new int[]{nx,ny});
            }
        }
        /*
        * 처음 q에 (0,0) 이 들어와 그리고 visited[0][0] 이 true로 바껴
        * */
    }
}


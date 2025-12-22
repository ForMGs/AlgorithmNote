package BfsDfs;
import java.util.*;
public class test_bfs01 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx ={0 , 1, 0 ,-1};
    static int[] dy ={1, 0 , -1 ,0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n  = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for( int x =0; x <n ; x ++){

            String line = sc.next();
            for(int y=0; y <m ; y++){

                map[x][y] = line.charAt(y) -'0';
            }
        }

    }

    static void bfs(int x , int y){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for(int idx = 0 ; idx <4 ; idx++){

                int nx  = cx + dx[idx];
                int ny  = cy + dy[idx];

                if(nx < 0 || ny <0 || nx >=n || ny >=m) continue;
                if(visited[nx][ny] || map[nx][ny] ==0) continue;

                visited[nx][ny] = true;
                map[nx][ny] = map[cx][cy] +1;
                q.offer(new int[]{nx,ny});
            }
        }


    }
}

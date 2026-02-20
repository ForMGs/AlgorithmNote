package BfsDfs;
import java.util.*;
import java.io.*;
public class B2178 {
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={0 , 1 , -1, 0};
    static int[] dy ={1, 0, 0,-1};

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0 ; i<m ; i++){
            String line = br.readLine();
            for(int j =0 ; j<n; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0,0 ,1);
    }

    public static void bfs(int x , int y ,int dept ){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new   int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int a=0; a<4; a++){
                 int nx = cur[0] + dx[a];
                 int ny = cur[1] + dy[a];

                if(nx <0 || nx >= m || ny<0 ||ny>=n){
                    continue;
                }

                if(visited[nx][ny] || map[nx][ny] ==0) continue;
                visited[nx][ny]=true;
                map[nx][ny] = map[cur[0]][cur[1]]+1;
                q.offer(new int[]{nx,ny});

            }
        }
        System.out.println(map[m-1][n-1]);

    }
}

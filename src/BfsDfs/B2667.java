package BfsDfs;
import java.util.*;
import java.io.*;
public class B2667 {
    static int[][] apt;
    static boolean[][] visited;
    static List<Integer> apart = new ArrayList<>();
    static int[] dx ={0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        apt = new int[N][N];
        visited= new boolean[N][N];
        for(int i=0 ; i<N;i++){
            String line = br.readLine();
            for(int j=0; j<N;j++){
                apt[i][j]=line.charAt(j) -'0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                if(apt[i][j]==1 && !visited[i][j]){
                    visited[i][j] =true;
                    bfs(new int[]{i,j});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        apart.sort((a,b)->a-b);
        sb.append(apart.size()).append("\n");
        for(int i: apart){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
     }
     static void bfs(int[] dong){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(dong);
        int count=1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx >= N|| nx <0 || ny >= N || ny<0 )continue;
                if(visited[nx][ny] || apt[nx][ny]==0) continue;

                visited[nx][ny]=true;
                q.offer(new int[]{nx,ny});
                count++;
            }
        }
        apart.add(count );
     }
}

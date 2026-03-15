package BfsDfs;
import java.util.*;
import java.io.*;
public class B1012 {
    static int tc;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int[] dx= {0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    public static void main(String[] args)throws Exception{
        //0 배추 심어지지 않은곳
        //1 배추가 심어진곳.
        // 단지수 체크하는 문제구만. 배추의 밀집도를 확인해서 단지수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc= Integer.parseInt(br.readLine());

        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int count=0;
            map = new int[x][y];
            visited = new boolean[x][y];
            for(int i =0; i<z;i++){
                StringTokenizer cabage = new StringTokenizer(br.readLine());
                int dx = Integer.parseInt(cabage.nextToken());
                int dy = Integer.parseInt(cabage.nextToken());
                map[dx][dy]= 1;

            }
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        visited[i][j]=true;
                        count++;
                        bfs(new int[]{i,j} ,x, y);
                    }
                }
            }
            result.add(count);
        }
        for(int i : result){
            System.out.println(i);
        }
    }
    static void bfs(int[] dir , int x , int y){
        Deque<int[]>q = new ArrayDeque<>();
        q.offer(dir);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if (nx >= x || nx < 0 || ny >= y || ny < 0) continue;
                if(map[nx][ny]==0 || visited[nx][ny]) continue;
                visited[nx][ny]=true;
                q.offer(new int[]{nx,ny});
            }
        }
    }
}

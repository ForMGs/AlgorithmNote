package BfsDfs;
import java.util.*;
import java.io.*;
public class B14442 {

    /**
     * N X M 행렬.. 0 이동 가능 1 이동 할 수 없는 벽.
     * 최단 경로 -> BFS
     * */
    static int[] dx ={0 ,1 ,-1,0};
    static int[] dy ={1 ,0 , 0,-1};
    static int[][] map;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int K;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][K+1];
        map = new int[N][M];
        for(int i =0;  i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) -'0';
            }
        }

        bfs();
    }
    static void bfs(){
        Deque<Point> q = new ArrayDeque<>();

        q.offer(new Point(0,0,0,1));
        boolean ok = false;
        while(!q.isEmpty()){
            Point p = q.pollFirst();
            if(p.x == N-1 && p.y==M-1){
                ok = true;
                System.out.println(p.dept);
                break;
            }
            for(int i =0; i<4; i++){
                int nx = p.x +dx[i];
                int ny = p.y +dy[i];

                if(nx<0 || nx >= N || ny<0 || ny >= M) continue;
                if(visited[nx][ny][p.count] ||
                        (map[nx][ny]==1 && p.count>=K)) continue;
                visited[nx][ny][p.count]=true;
                if(map[nx][ny] == 1){
                    q.addLast(new Point(nx,ny,p.count+1,p.dept+1));
                }else{
                    q.addLast(new Point(nx,ny,p.count,p.dept+1));
                }


            }

        }
        if(!ok){
            System.out.println(-1);
        }
    }
    static class Point{
        int x;
        int y;
        int count;
        int dept;

        Point(int x, int y , int count ,int dept){
            this.x=x;
            this.y=y;
            this.count=count;
            this.dept = dept;
        }
    }
}

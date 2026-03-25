package BfsDfs;
import java.util.*;
import java.io.*;
public class B2206 {

    public static void main(String[] args )throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[N][M][2];
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j]  = line.charAt(j)-'0';
            }
        }
        Deque<Point> q= new ArrayDeque<>();
        q.offer(new Point(0,0,0,1));
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!q.isEmpty()){
            Point point = q.poll();
            if(point.x == N-1 && point.y==M-1){
                System.out.println(point.dept);
                return;
            }
            for(int i=0; i<4; i++){
                int nx = point.x+dx[i];
                int ny= point.y+dy[i];
                if(nx<0  || nx >=N || ny <0 || ny >=M) continue;
                if(map[nx][ny]==1){
                    if(point.broke != 0){
                        continue;
                    }
                    if(visited[nx][ny][1]) continue;
                    visited[nx][ny][1]=true;
                    q.offer(new Point(nx,ny,1,point.dept+1));
                }else{
                    if(visited[nx][ny][point.broke]) continue;
                    visited[nx][ny][point.broke] =true;
                    q.offer(new Point(nx,ny,point.broke,point.dept+1));
                }
            }
        }
        System.out.println(-1);

    }
    static class Point{
        int x;
        int y;
        int broke;
        int dept;
        Point(int x, int y, int broke ,int dept){
            this.x =x;
            this.y =y;
            this.broke = broke;
            this.dept = dept;
        }
    }
}

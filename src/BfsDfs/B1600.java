package BfsDfs;
import java.util.*;
import java.io.*;
public class B1600 {
    static int max;
    static int N;
    static int M;
    static int[][] map ;
    static boolean[][][] visited;
    static int[] dx ={-1,-2,-2,-1,1,2,2,1,0,1,0,-1};
    static int[] dy ={-2,-1,1,2,-2,-1,1,2,1,0,-1,0};
    static int[] hx ={};
    static int[] hy ={};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited  = new boolean[M][N][max+1];
        for(int i=0; i<M; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N; j++){
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        bfs();
    }
    static class Monkey{
        int cx ;
        int cy ;
        int moving;
        int dist;
        Monkey(int cx , int cy , int moving ,int dist){
            this.cx = cx;
            this.cy = cy;
            this.moving = moving;
            this.dist = dist;
        }
        @Override
        public String toString(){
            return "좌표 [ "+this.cx+","+this.cy+" ]" + "움직임 : "+this.moving+" 거리 :  "+this.dist;
        }
    }
    static void bfs(){
        Deque<Monkey> q = new ArrayDeque<>();
        q.addLast(new Monkey(0,0,0,0));
        visited[0][0][0] =true;
        boolean done =false;
        while(!q.isEmpty()){
            Monkey monkey = q.pollFirst();
//            System.out.println("꺼내기 === "+monkey);
            if(monkey.cx==M-1 && monkey.cy==N-1) {
                System.out.println(monkey.dist);
                done =true;
                break;
            }
            for(int i =0; i<12; i++){
                if(monkey.moving ==max && i<8) continue;
                int nx = monkey.cx + dx[i];
                int ny = monkey.cy + dy[i];
                if(nx>=M || nx<0 || ny>=N||ny<0) continue;
                if(map[nx][ny]==1) continue;
                if(i<8 && visited[nx][ny][monkey.moving+1]) continue;
                if(i>=8 && visited[nx][ny][monkey.moving]) continue;

                if(i<8){
                    visited[nx][ny][monkey.moving+1] = true;
                    q.addLast(new Monkey(nx,ny,monkey.moving+1,monkey.dist+1));
//                    System.out.println("넣기 === "+q.peekLast());
                }else{
                    visited[nx][ny][monkey.moving]=true;
                    q.addLast(new Monkey(nx,ny,monkey.moving,monkey.dist+1));
//                    System.out.println("넣기 === "+q.peekLast());

                }
            }
        }
        if(!done){
            System.out.println(-1);
        }

    }
}

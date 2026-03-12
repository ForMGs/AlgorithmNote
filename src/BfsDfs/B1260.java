package BfsDfs;
import java.util.*;
import java.io.*;
public class B1260 {
    static int N;
    static int M;
    static int start;
    static boolean[][] map;
    static boolean[] visited;
    static int[] road;
    static StringBuilder sDfs= new StringBuilder();
    static StringBuilder sBfs= new StringBuilder();

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int x  = Integer.parseInt(line.nextToken());
            int y  = Integer.parseInt(line.nextToken());
            map[x][y]=true;
            map[y][x]=true;
        }
        road = new int[N];
        visited = new boolean[N+1];
        DFS(start,0);
        System.out.println(sDfs);
        visited = new boolean[N+1];
        BFS(start);
    }
    static void DFS(int start, int dept ){
        sDfs.append(start).append(" ");

        visited[start]=true;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            if(map[start][i]){
                visited[i]=true;
                DFS(i,dept+1);
            }
        }
    }
    static void BFS(int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);
        visited[start]=true;

        sBfs.append(start).append(" ");
        while(!q.isEmpty()){
            int search = q.pollFirst();
            for(int i=1; i<=N;i++){
                if(visited[i]) continue;
                if(map[search][i]){
                    visited[i]=true;
                    q.addLast(i);
                    sBfs.append(i).append(" ");
                }
            }
        }
        System.out.println(sBfs);
    }
}

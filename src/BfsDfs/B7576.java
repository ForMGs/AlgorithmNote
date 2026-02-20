package BfsDfs;
import java.util.*;
import java.io.*;
public class B7576 {
    static int m;
    static int n;
    static int[][] map;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,-1,0,1};
    static int count =0;
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map=new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n;i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int apple = Integer.parseInt(line.nextToken());
                map[i][j] = apple;
                if(1==apple){
                    q.offer(new int[]{i,j});
                }
                if(0==apple){
                    count++;
                }

            }
        }

        int days =0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean progressed = false;

            for(int s =0; s <size; s++){
                int[] cur= q.poll();

                for(int d= 0; d<4; d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if(nx<0 || ny<0 || nx >=n || ny >=m) continue;
                    if(map[nx][ny] != 0 )continue;

                    map[nx][ny]=1;
                    count--;
                    progressed =true;
                    q.offer(new int[]{nx,ny});
                }
            }
            if(progressed) days++;
        }
        System.out.println(count==0?days:-1);
    }




}

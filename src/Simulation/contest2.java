package Simulation;
import java.util.*;
public class contest2 {
    public static  int solution(int K, int[][] A) {
            // Implement your solution here
            int n = A.length;
            int m = A[0].length;

            int[][] visit = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int count = 0;

            int[] dx = {1, -1 , 0 , 0};
            int[] dy = {0, 0, -1, -1};

            for(int i =0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(A[i][j] == 1){
                        count ++;
                        visited[i][j] = true;
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i,j,0});

                        while(!q.isEmpty()) {
                            int[] cur = q.poll();
                            int x = cur[0];
                            int y = cur[1];
                            int far = cur[2];

                            if(far > K) continue;

                            visit[x][y]++;

                            for(int z = 0; z < 4; z++){
                                int nx = x + dx[z];
                                int ny = y + dy[z];

                                if(nx >=0 && ny >=0 && nx < n && ny <m && !visited[nx][ny]){
                                    visited[nx][ny] = true;
                                    q.offer(new int[]{nx, ny , (far +1)});
                                }
                            }
                        }
                    }
                }
            }

            int result = 0; 
            for(int i =0; i < n ; i++){
                for (int j=0; j< m; j++){
                    if(A[i][j] ==0 && visit[i][j] == count){
                        result ++;
                    }
                }
            }

            return result;
    }
    public static void main(String[] args) {
        int[][] x=  new int[][]{{0,0,0,0} , {0,0,1,0} , {1,0,0 ,1}};
        
        System.out.print(solution( 2,x));
    }
}

package BfsDfs;

import java.util.*;

public class bfs03 {
    /*

    * **/

    static int m , n;
    static boolean[][] visited;
    static int[][] map;
    static int MIN_VALUE =2;
    static int MAX_VALUE = 1000;
    static int[]dx ={0 ,-1, 1,0};
    static int[]dy= {1,0,0,-1};
    static int count=0;
    static ArrayDeque<int[]> q = new ArrayDeque<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        visited = new boolean[n][m];
        map = new int[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int app = sc.nextInt();
                map[x][y] = app;  // -1 그대로 들어감
                if(app == 0){
                    count++;
                }
                if(app ==1 ){
                    q.offer(new int[]{x,y});
                }

            }
        }

        System.out.println(bfs(count));


    }

    static int bfs(int count){
        if(count ==0) return 0;

        int days = -1;


        while(!q.isEmpty()){

            int size= q.size();

            for(int j =0 ; j < size ; j ++){
                int[] cur = q.poll();
                int nx = cur[0];
                int ny = cur[1];

                for(int i =0; i< 4; i++){


                    int rx = nx + dx[i];
                    int ry = ny + dy[i];

                    if(rx < 0 || rx >=n || ry < 0 || ry >=m) continue;
                    if(visited[rx][ry] || map[rx][ry] == -1 || map[rx][ry] == 1) continue;

                    visited[rx][ry] = true;
                    map[rx][ry] =1;
                    q.offer(new int[]{rx,ry});
                    count = count-1;
            }


            }
            days ++;
        }

        if(count>0)return -1;
        return days;
    }
}

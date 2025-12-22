package BfsDfs;

import java.util.*;

/*
* 1은 집이 있는 / 0은 집이 없는
* 만약 0,0 에서 동서남북 에서 1이있다. 이어진거 q에 동서남북 중 있는거에 넣어
* */
public class bfs04 {

    static int m;
    static Map<Integer, Integer> apts = new HashMap<>();
    static int[][] map;
    static int[] dx = {0 , -1 ,0 ,1};
    static int[] dy = {1 , 0 , -1 ,0};
    static int idx=0;
    static boolean[][] visited;
    static int ho =0;
    static ArrayList<Integer> result = new ArrayList<>();



    public static void main(String[] args) {

        Scanner sc =new  Scanner(System.in);

        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        visited = new boolean[m][m];

        bfs(m , idx);

        int size = apts.size();
        for(int z=0; z < size; z++){
            if(apts.get(z) !=0){
                ho ++;
                result.add(apts.get(z));

            }
        }
        Collections.sort(result);

        for(int k =0 ;  k < result.size(); k ++){
            if(k==0) System.out.println(ho + "\n");
            System.out.println(result.get(k) + "\n");
        }


    }

    static void bfs(int m , int idx){
        int count = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){

            int[] cur = q.poll();
            int rx = cur[0];
            int ry = cur[1];
            visited[rx][ry] =true;

            for(int i=0; i < 4 ; i ++){

                int nx = rx + dx[i];
                int ny = ry + dy[i];

                if(nx < 0|| nx >=m || ny <0 || ny >=m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1){
                    apts.put(idx , ++count);
                    q.offer(new int[]{nx ,ny});
                }else{
                    bfs(m, ++idx);
                }

            }

        }

    }
}
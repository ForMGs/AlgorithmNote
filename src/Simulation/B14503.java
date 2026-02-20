package Simulation;
import java.util.*;
import java.io.*;

public class B14503 {

    static int n ,m;
    static int[][] map ;
    static int[] dx ={-1,0,1,0 };
    static int[] dy ={0,1, 0,-1};
    static int[] state = new int[3];
    static boolean[][]  visited;
    static int count =0;
    //0-북 1-동 2-남 3-서
//    //0 청소할 칸 1 벽
//    public static void main(String[] args) throws Exception{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        map = new int[n][m];
//        visited =new boolean[n][m];
//
//        st= new StringTokenizer(br.readLine());
//        state[0]= Integer.parseInt(st.nextToken());
//        state[1]= Integer.parseInt(st.nextToken());
//        state[2]= Integer.parseInt(st.nextToken());
//
//        for(int i = 0 ; i < n ; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j =0; j <m ; j++){
//                map[i][j]= Integer.parseInt(st.nextToken());
//            }
//        }
//        //처음 시작 칸 빈칸으로 ...
//
//        bfs();
//        System.out.println(count);
//    }
//    static void bfs(){
//
//        ArrayDeque<int[]> q = new ArrayDeque<>();
//        q.offer(new int[]{state[0],state[1],state[2]});
//
//        while(!q.isEmpty() ){
//
//            int[] cur = q.poll();
//            int x= cur[0];
//            int y= cur[1];
//            int z= cur[2];
//            System.out.println(x +" " +y +" "+z);
//            boolean go =false;
//
//            //현재 칸이 청소해야하면 count 늘어남.
//            if(map[x][y]==0 && visited[x][y]==false){
//                count++;
//                visited[x][y] = true;
//
//            }
//            // 주변에 청소할 칸이 있는지 체크
//            for(int i =0; i<4; i++){
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//
//                if(nx<0 || ny <0 || nx >= n|| ny>=m) continue;
//                if(map[nx][ny] ==1 || visited[nx][ny]) continue;
//                go = true;
//                break;
//            }
//            //청소할 칸이 있는경우 반시계방향 회전 and 한칸 전진
//            if(go){
//                int base = state[2];
//                rotation(z);
//                int xx= state[0]+dx[state[2]];
//                int yy= state[1]+dy[state[2]];
//
//
//                if((xx>=0&&xx<n&&yy>=0&&yy<m) && map[xx][yy] == 0 && visited[xx][yy]==false){
//                    state[0]=xx;
//                    state[1]=yy;
//                }else{
//                    state[2]=base;
//                }
//                q.offer(new int[]{state[0],state[1],state[2]});
//            }else{
//                //청소할 칸이 없는 경우 후진 벽인 경우 멈춤
//                if(back(z)){
//                    q.offer(new int[]{state[0],state[1],state[2]});
//                }
//            }
//        }
//    }
//    static void rotation(int wr){
//        switch(wr){
//            case(0):
//                state[2]=3;
//                break;
//            case(1):
//                state[2]=0;
//                break;
//            case(2):
//                state[2]=1;
//                break;
//            case(3):
//                state[2]=2;
//                break;
//        }
//    }
//    static boolean back(int bk ){
//        state[0] = state[0] - (dx[bk]);
//        state[1] = state[1] - (dy[bk]);
//        if(state[0]<0|| state[1]<0|| state[0]>=n|| state[1]>=m||(map[state[0]][state[1]]==1)) return false;
//
//        return true;
//    }
//
//    static int n, m;
//    static int[][] map;
//    // 북(0), 동(1), 남(2), 서(3) 순서 (문제의 d 값과 일치)
//    static int[] dx = {-1, 0, 1, 0};
//    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(r, c, d);
    }

    static void solve(int r, int c, int d) {
        int count = 0;

        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시 (1은 벽이므로 2로 구분)
                count++;
            }

            boolean cleanable = false;
            // 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        cleanable = true;
                        break;
                    }
                }
            }

            if (cleanable) {
                // 3. 현재 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                for (int i = 0; i < 4; i++) {
                    // 반시계 방향으로 90도 회전
                    d = (d + 3) % 4;
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    // 바라보는 방향의 앞쪽 칸이 청소되지 않은 빈 칸일 경우 한 칸 전진
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                        r = nx;
                        c = ny;
                        break;
                    }
                }
            } else {
                // 2. 현재 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                // 바라보는 방향을 유지한 채로 한 칸 후진
                int backD = (d + 2) % 4;
                int bx = r + dx[backD];
                int by = c + dy[backD];

                // 후진할 수 있다면 후진 (벽이 아니어야 함)
                if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
                    r = bx;
                    c = by;
                } else {
                    // 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    System.out.println(count);
                    return;
                }
            }
        }
    }

}


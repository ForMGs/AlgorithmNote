package Samsung;

import java.util.*;
import java.io.*;

public class B20057 {
    static int n ;
    static int[][] map;
    static int[] dx = { -1, 0 , 1, 0};
    static int[] dy = {0 , 1 , 0 ,-1};
    static int result =0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i< n; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }


    }
    //왼 - > 아 -> 오 -> 위
    static void tornado(){

        int x =  n / 2;
        int y =  n / 2;
        int len = 1;
        int dir = 0;
        while(!(x==0 && y==0)){

            for(int i=0; i<2; i++){

                for(int j=0; j < len ; j++){
                    x += dx[dir];
                    y += dy[dir];

                    //모래 퍼트리기 로직 수행..
                    if(x==0 && y==0) break;
                    spread(x, y ,dir);
                }
                dir= (dir+1)%4; //방향전환
                if(x==0  && y==0) break;
            }
            len++;
        }

    }
    /*
    * 현 위치에서 위 아래 1%/ 앞 대각선  7% 앞 /대각석 위 아래 2% / 이동후 앞 대각선 10% / 이동후 앞앞 5%
    * */
    static void spread(int x, int y , int dir){
        //현 위치 모래양 체크
        int curSand = map[x][y];
        //dir 0 --> 왼  1-> 아래 2 -> 오 3-> 위

    }
}

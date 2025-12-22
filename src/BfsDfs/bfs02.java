package BfsDfs;
import java.util.*;

/*
* 문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
* 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.*/

public class bfs02 {

//    만약에 출발 위치가 x 야 도착 위치가 y 인데  x*2 < y -> 무조건 순간이동해야지  <-- 우선 이걸로 계속해 그러다가 아래같은 상황이 나오면 되돌아가
//    근데  x*2 > y  이때는 어떤 알고리즘을 써야하냐?
    // start -1 / start +1 / start *2  뭐가 더 가까워?

    static int start , end ;
    static int[] k = {1 , -1 ,2};
    static int[][] dis = new int[3][2];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        end = sc.nextInt();

        int result = bfs(start, end);
        System.out.println(result);
    }

    static int bfs(int start, int end){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start,end});
        int result= 0;

        while(!q.isEmpty()){
            System.out.println("result : "+result);
            result +=1;
            int[] cur = q.poll(); //5 17
            System.out.println(cur[0]+" "+cur[1]);
            for(int i=0; i<k.length; i++){
                int cx = cur[0];

                if(i == 2){
                    dis[i][0] = cx * k[i];
                    dis[i][1] = Math.abs(end - (cx * k[i]));
                }else {
                    dis[i][0] = cx + k[i];
                    dis[i][1] = Math.abs(end - (cx + k[i]));

                }
            }

            int min = Integer.MAX_VALUE;
            int minX  = -1;

            for(int i=0; i<dis.length; i++){

                if(dis[i][1] < min){
                    min = dis[i][1];
                    minX = i;
                }
            }
            if(dis[minX][0] == end){
                break;
            }else{
                q.offer(new int[]{dis[minX][0],end});
            }
            if(result == 10){
                break;
            }


        }



        return result;

    }
}

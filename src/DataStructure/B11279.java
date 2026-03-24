package DataStructure;
import java.util.*;
import java.io.*;
public class B11279 {
    /**
     * 배열에 자연수 x를 넣는다.
     * 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
     * */
    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        int size = N;
        List<Integer> list = new ArrayList<>();
        int idx =0;
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            int M = Integer.parseInt(br.readLine());
            if(M==0){
                if(q.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(q.poll()).append("\n");
            }
            q.offer(M);
        }
        System.out.println(sb);

    }
}

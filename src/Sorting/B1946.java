package Sorting;
import java.util.*;
import java.io.*;
public class B1946 {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            List<int[]> list = new ArrayList<>();
            int M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y =Integer.parseInt(st.nextToken());
                list.add(new int[]{x,y});
            }
            list.sort((a,b)->{
                return Integer.compare(a[0],b[0]);
            });
            int count =1;
            int Min_Y = list.get(0)[1];

            for(int i=1; i<M; i++){
                int score = list.get(i)[1];
                if(score < Min_Y){
                    count++;
                    Min_Y = score;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}



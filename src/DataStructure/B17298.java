package DataStructure;
import java.util.*;
import java.io.*;
public class B17298 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0;  i<N-1; i++){
            int first = arr[i];
            int second=0;
            int max =0;

            for(int j = i+1 ; j <N; j++  ){
                second = arr[j];
                if(max !=0 && first > second) break;
                max= Math.max(Math.max(first, second), max);

            }
            if(first == max) sb.append("-1 ");
            else sb.append(max+" ");
        }
        System.out.println(sb.append("-1"));

    }
}

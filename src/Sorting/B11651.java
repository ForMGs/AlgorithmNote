package Sorting;
import java.util.*;
import java.io.*;
public class B11651 {

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opt = Integer.parseInt(br.readLine());
        List<int[]> dir = new ArrayList<>();
        for(int i=0; i<opt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        dir.sort((a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int[] x : dir){
            sb.append(x[0]).append(" ").append(x[1]).append("\n");
        }
        System.out.println(sb);
    }
}

package Sorting;
import java.util.*;
import java.io.*;

public class B1920 {

    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer arr = new StringTokenizer(br.readLine());
        while(M-->0){
            if(set.contains(Integer.parseInt(arr.nextToken()))) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }
}

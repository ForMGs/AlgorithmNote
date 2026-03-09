package Sorting;
import java.util.*;
import java.io.*;

public class B10816 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer sArr1 = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i =0 ; i<N ; i++){
            int num = Integer.parseInt(sArr1.nextToken());
            if(map.containsKey(num)){
                map.compute(num, (k, value) -> value + 1);
            }else{
                map.put(num,1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer sArr2=  new StringTokenizer(br.readLine());
        while(M-->0){
            int num = Integer.parseInt(sArr2.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)).append(" ");
            }else{
                sb.append("0 ");

            }
        }
        System.out.println(sb);
    }

}

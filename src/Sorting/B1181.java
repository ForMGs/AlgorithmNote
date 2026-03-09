package Sorting;
import java.util.*;
import java.io.*;
public class B1181 {
    public static void main(String[] args)throws Exception{
        TreeMap<String, String> map = new TreeMap<>((a,b)->{
            int aleng = a.length();
            int bleng = b.length();
           if(aleng != bleng)return aleng-bleng;
           else{
               return a.compareTo(b);
           }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            map.put(br.readLine(),"");
        }
        StringBuilder sb = new StringBuilder();
        while(!map.isEmpty()){
            sb.append(map.firstKey()).append("\n");
            map.pollFirstEntry();
        }
        System.out.println(sb);
    }
}

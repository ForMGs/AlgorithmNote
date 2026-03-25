package Greedy;
import java.util.*;
import java.io.*;
public class B11047 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        while(N-->0){
            coin[N] = Integer.parseInt(br.readLine());
        }
        int count =0;
        int dept =0;
        while(money > 0){
            if(money >= coin[dept]){
                money = money - coin[dept];
                count++;
            }else{
                dept++;
            }
        }
        System.out.println(count);
    }
}

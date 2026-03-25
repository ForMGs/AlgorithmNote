package DataStructure;
import java.util.*;
import java.io.*;
public class B1715 {
    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        while(N-->0){
            q.offer(Integer.parseInt(br.readLine()));
        }
        int sum =0;
        if(q.size()==1){
            System.out.println(0);
        }else{
            while(true){
                int num1 = q.poll();
                int num2 = q.poll();
                int num3 = num1+num2;
                sum += num3;
                if(q.isEmpty()){
                    System.out.println(sum);
                    return;
                }else{
                    q.offer(num3);
                }
            }
        }

    }
}




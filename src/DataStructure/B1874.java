package DataStructure;
import java.util.*;
import java.io.*;

public class B1874 {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        for(int i=0; i< N; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(int i =1 ; i<=N; i++){

            stack.addFirst(i);
            sb.append("+\n");
            while(!stack.isEmpty() && arr[idx]==stack.peekFirst()){
                stack.pollFirst();
                sb.append("-\n");
                idx++;
            }

        }
        if(!stack.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
    }
}

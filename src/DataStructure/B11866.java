package DataStructure;
import java.util.*;
import java.io.*;

public class B11866 {

    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i =1; i<=N; i++){
            q.addLast(i);
        }
        int count =1;
        boolean out =false;
        while(!q.isEmpty()){
            if(count++%M==0 || q.size()==1){
                out=true;
            }
            if(out){
                sb.append(q.pollFirst());
            }else{
                q.addLast(q.pollFirst());
            }
            if(out){
                if(!q.isEmpty()){
                    sb.append(", ");
                }else{
                    sb.append(">");
                }
            }
            out=false;

        }
        System.out.println(sb);
    }
}

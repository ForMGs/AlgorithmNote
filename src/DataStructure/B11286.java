package DataStructure;
import java.util.*;
import java.io.*;
public class B11286 {
    public static void main(String[] arsgs)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while(N-- >0){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                plusQ.add(num);
            }else if(num < 0){
                minusQ.add(num);
            }else{
                if(plusQ.isEmpty() && minusQ.isEmpty()){
                    sb.append("0\n");
                    continue;
                }
                if(plusQ.isEmpty() || minusQ.isEmpty()){
                    if(plusQ.isEmpty()){
                        sb.append(minusQ.poll()).append("\n");
                    }else{
                        sb.append(plusQ.poll()).append("\n");
                    }
                    continue;
                }
                if(Math.abs(plusQ.peek())< Math.abs(minusQ.peek())){
                    sb.append(plusQ.poll()).append("\n");
                }else{
                    sb.append(minusQ.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

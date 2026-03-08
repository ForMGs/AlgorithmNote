package DataStructure;
import java.util.*;
import java.io.*;

public class B2493 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            top[i]= Integer.parseInt(st.nextToken());
        }
        //룰
        //뽑아 -> q가 비어있어 패스하고 stackq에 넣어
        Deque<Integer> stack = new ArrayDeque<>();
        while(N-- >0){
            int tower1 = top[N];
//            System.out.println(N);
            while(!stack.isEmpty() && top[stack.peek()] < tower1){
//                System.out.println("while 내부 : "+ stack.peek());
                result[stack.peek()] = N+1;
                stack.pollFirst();
            }
            stack.addFirst(N);

        }
        while(!stack.isEmpty()){
//            System.out.println("0처리 idx  : " + stack.peek());
            result[stack.pollFirst()] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< result.length; i++){
            sb.append(result[i]+" ");
//            System.out.println(result[i]);
        }
        System.out.println(sb);

    }

}

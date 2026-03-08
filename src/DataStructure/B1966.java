package DataStructure;
import java.util.*;
import java.io.*;

public class B1966 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            Deque<Document> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int wantIdx = Integer.parseInt(st.nextToken());
            StringTokenizer arr = new StringTokenizer(br.readLine());
            int count =0;


            for(int i =0; i<number ;i++){
                int cur = Integer.parseInt(arr.nextToken());
                pq.offer(cur);
                q.addLast(new Document(cur,i));
            }
            while(!q.isEmpty()){
                if(!pq.isEmpty() && (pq.peek()== q.peekFirst().level)){
                    count++;
                    if(q.peekFirst().idx == wantIdx){
                        sb.append(count+"\n");
                        break;
                    }
                    q.pollFirst();
                    pq.poll();
                }else{
                    q.addLast(q.pollFirst());
                }
            }
        }
        System.out.println(sb);
    }
    static class Document{
        int level;
        int idx;

        Document(int level ,int idx){
            this.level = level;
            this.idx = idx;
        }

    }
}

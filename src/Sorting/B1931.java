package Sorting;
import java.util.*;
import java.io.*;
public class B1931 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meet> room = new ArrayList<>();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            room.add(new Meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(room);
        int prev =0;
        int count =0;
        for(Meet m : room){
            if(prev<= m.start){
                count++;
                prev = m.end;
            }
        }
        System.out.println(count);
    }

    static class Meet implements Comparable<Meet> {
        int start;
        int end;
        int time;

        Meet(int start, int end){
            this.start = start;
            this.end = end;
            this.time = end-start;
        }

        @Override
        public int compareTo(Meet o) {
            // 1. 종료 시간 기준
            if (this.end != o.end) {
                return this.end - o.end;
            }
            // 2. 시작 시간 기준
            return this.start - o.start;
        }
        @Override
        public String toString(){
            return this.start +" ~ "+this.end;
        }
    }
}

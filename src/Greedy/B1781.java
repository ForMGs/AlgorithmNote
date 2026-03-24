package Greedy;
import java.io.*;
import java.util.*;
public class B1781 {

    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        List<CupLamen> list = new ArrayList<>();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new CupLamen(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        PriorityQueue<Integer>q = new PriorityQueue<>();
        for(CupLamen c : list){
            q.offer(c.repair);
            if(q.size()>c.deadLine){
                q.poll();
            }
        }
        int sum=0;
        while(!q.isEmpty()){
            sum += q.poll();
        }
        System.out.println(sum);
    }
    static class CupLamen implements Comparable<CupLamen>{
        int deadLine ;
        int repair ;
        CupLamen(int deadLine, int repair){
            this.deadLine = deadLine;
            this.repair = repair;
        }
        @Override
        public int compareTo(CupLamen c){

            if(this.deadLine != c.deadLine){
                return Integer.compare(this.deadLine,c.deadLine);
            }
            return Integer.compare(c.repair,this.repair);
        }
        @Override
        public String toString(){
            return this.deadLine +" "+ this.repair;
        }


    }

    /**
     * 상욱이가 동호에게 N개의 문제를 줌 , 각각의 문제를 풀때 컵라면을 몇 개 줄것이지 제시..
     * 각각의 문제에 대한 데드라인을 정함.
     * 받을 수 있는 컵라면 최대 수를 구해라..
     * 1 7
     * 1 6
     * 2 5
     * 2 4
     * 3 2
     * 3 1
     * 6 1
     * */
}

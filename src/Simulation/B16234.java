package Simulation;
import java.util.*;
import java.io.*;
public class B16234 {
    static int size ;
    static int minSize;
    static int maxSize;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int result;
    static List<PeopleMove> list;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size= Integer.parseInt(st.nextToken());
        minSize= Integer.parseInt(st.nextToken());
        maxSize= Integer.parseInt(st.nextToken());
        map = new int[size][size];
        for(int i=0; i<size; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j =0; j<size;j++){
                map[i][j]=Integer.parseInt(line.nextToken());
            }
        }
        while(true){
            list = new ArrayList<>();
            boolean[][] visited = new boolean[size][size];
            boolean end =false;
            int count=0;
            for(int i=0; i<size; i++){
                for(int j=0; j<size;j++){
                    if(visited[i][j])continue;
                    List<int[]> c = new ArrayList<>();
                    c.add(new int[]{i,j});
                    visited[i][j]=true;
                    if(end){
                        bfs(new PeopleMove(count,c),visited );
                    }else{
                        end= bfs(new PeopleMove(count,c),visited );

                    }
                    count++;
                }
            }
            if(!end){
                System.out.println(result);
                break;
            }else{
                changePeople();
            }
            result++;
        }

    }
    static boolean bfs(PeopleMove people , boolean[][] visit){
        Deque<int[]> q= new ArrayDeque<>();
        q.offer(people.country.get(0));
        boolean work = false;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0 ;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx>=size || nx<0 || ny>=size|| ny<0) continue;
                if(visit[nx][ny]) continue;
                int dif = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if(dif>maxSize || dif <minSize) continue;
                visit[nx][ny]=true;
                q.offer(new int[]{nx,ny});
                people.country.add(new int[]{nx,ny});
                work = true;
            }
        }
        if(work) list.add(people);
//        System.out.println(people);
        return work;
    }
    static void changePeople(){
        for(PeopleMove p : list){
            int total =0;
            for(int[] dir : p.country){
                total+= map[dir[0]][dir[1]];
            }
            total = total/p.country.size();
            for(int[] dir: p.country){
                map[dir[0]][dir[1]] = total;
            }

        }
    }
    static class PeopleMove{
        int group;
        List<int[]> country;

        PeopleMove(int group, List<int[]>country ){
            this.group= group;
            this.country= country;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int[] dir: this.country){
                sb.append("좌표[ ").append(dir[0])
                        .append(", ")
                        .append(dir[1])
                        .append("]")
                        .append("\n");
            }
            return "그룹 : "+this.group+"좌표들  " +sb;
        }
    }
}

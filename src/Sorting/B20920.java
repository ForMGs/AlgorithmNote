package Sorting;
import java.util.*;
import java.io.*;
public class B20920 {
    public static void main(String[] args)throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> note = new TreeMap<>();

        while(N-->0){
            String target = br.readLine();
            if(target.length()<M) continue;
            if(note.containsKey(target)){
                note.compute(target, (k, num) -> num + 1);
            }else{
                note.put(target,1);
            }
        }
        List<Map.Entry<String,Integer>> noteList = new ArrayList<>(note.entrySet());
        noteList.sort((a,b)->{
            if(a.getValue()!=b.getValue()){
                return b.getValue()- a.getValue();
            }
            if(a.getKey().length()!= b.getKey().length()){
                return b.getKey().length()- a.getKey().length();
            }
            return CharSequence.compare(a.getKey(),b.getKey());
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String , Integer> k:noteList){
            sb.append(k.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}

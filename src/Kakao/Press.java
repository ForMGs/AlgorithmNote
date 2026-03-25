package Kakao;
import java.util.*;
import java.io.*;
public class Press {
    public static void main(String[] args )throws Exception{
        solution("KAKAO");
        solution("TOBEORNOTTOBEORTOBEORNOT");
        solution("ABABABABABABABAB");

    }
    public static int[] solution(String msg) {
        Map<String , Integer> rib = new HashMap<>();
        Deque<Character> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(char s : msg.toCharArray()){
            q.addLast(s);
        }
        int idx =27;
        while(!q.isEmpty()){
            StringBuilder sb = new StringBuilder();
            char word = q.pollFirst();
            sb.append(word);
            int exp = word -'A' +1;
            while(!q.isEmpty()){
                sb.append(q.peekFirst());
                if(rib.containsKey(sb.toString())){
                    exp = rib.get(sb.toString());
                    q.pollFirst();
                }else{
                    rib.put(sb.toString(),idx++);
                    break;
                }
            }
            list.add(exp);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}

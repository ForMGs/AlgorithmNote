package DataStructure;
import java.util.*;
import java.io.*;

public class B1158 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int person = Integer.parseInt(st.nextToken());
        int del = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder("<");
        boolean[] people = new boolean[person];
        int count =1;
        int idx = 0;
        int play = person;

        while(play > 1){

            if(count == del && people[idx]==false){


//                System.out.println("찾음 " + "count : " + count +" idx : "+(idx+1));
                count =1;
                play --;
                people[idx]=true;
                result.append((idx+1)+", ");
                if((idx+1) == person){
                    idx =0;
                }else{
                    idx++;
                }
                continue;
            }


//            System.out.println("순서 : "+(idx+1) + " count : " + count);
            if(people[idx] == false){
                count ++;
            }
            if((idx+1) == person){
                idx =0;
            }else{
                idx ++;

            }
        }
        for(int i =0; i< person; i++){
            if(people[i] == false){
                System.out.println(result.append((i+1)+">"));
                break;
            }
        }



    }
}


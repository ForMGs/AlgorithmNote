package Greedy;
import java.util.*;
import java.io.*;

public class B1213 {
    static int left;
    static int right =1 ;
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int length = name.length();
        char[] result = new char[length];
        Map<Character ,Integer> alpa = new TreeMap<>();
        for(int i=0 ; i<name.length(); i++){
            alpa.compute(name.charAt(i),(k,v)->(v==null)? 1:v+1);
        }
        boolean oddNum =false;

        for(Map.Entry<Character, Integer> entry: alpa.entrySet()){
            int count = entry.getValue();
            char key = entry.getKey();
            if(count % 2 != 0){
                if(oddNum){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                oddNum =true;
                result[length/2]= key;
                for(int i=0; i<count-1; i++){

                    if(i%2 !=0) {
                        result[left++]=key;
                    }
                    else{
                        result[length-right]=key;
                        right++;
                    }
                }
            }else{
                for(int i=0; i<count; i++){

                    if(i%2 !=0) {
                        result[left++]=key;
                    }
                    else{
                        result[length-right]=key;
                        right++;
                    }
                }
            }
        }
        System.out.println(result);

    }

}

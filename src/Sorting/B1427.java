package Sorting;
import java.util.*;
import java.io.*;
public class B1427 {

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int length = number.length();
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<length ; i++){
            arr.add((number.charAt(i)-'0'));
        }
        arr.sort((a,b)->{
            if(a!=b) return b-a;
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        System.out.println(sb);
    }
}

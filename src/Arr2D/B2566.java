package Arr2D;

import java.util.*;
import java.io.*;

public class B2566 {
    static int n,m;
    static int max=0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i =0 ; i< 9 ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j< 9; j++){
                int num = Integer.parseInt(st.nextToken());
                if(max <= num ){
                    max = num;
                    n=i;
                    m=j;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(max);
        answer.append("\n");
        answer.append((n+1)+" "+(m+1)) ;
        System.out.println(answer.toString());
    }
}

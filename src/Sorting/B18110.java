package Sorting;
import java.util.*;
import java.io.*;
public class B18110 {
    public static void main(String[]args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        for(int i=0; i<N;i++){
            int num =Integer.parseInt(br.readLine());
            people[i]=num;
        }
        int middle = (int)Math.round(N*15/100.0);
        Arrays.sort(people);
        int result =0;
        for(int i = middle; i<N-middle; i++){
            result += people[i];
        }
        System.out.println(Math.round((float) result /(N-middle*2)));
    }
}

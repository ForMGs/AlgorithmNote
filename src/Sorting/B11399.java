package Sorting;
import java.io.*;
import java.util.*;

public class B11399 {

    public static void main(String[] args )throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        int sum=arr[0];

        for(int i=1; i<n;i++){
            arr[i]=arr[i]+arr[i-1];
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}

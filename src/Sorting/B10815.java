package Sorting;
import java.util.*;
import java.io.*;
public class B10815 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer sArr1 = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer sArr2 = new StringTokenizer(br.readLine());

        int[] arr1 = new int[N];
        for(int i=0;i<N; i++){
            arr1[i]=Integer.parseInt(sArr1.nextToken());
        }
        Arrays.sort(arr1);
        StringBuilder sb = new StringBuilder();

        while(M-->0){
            int target = Integer.parseInt(sArr2.nextToken());

            if(binarity(target ,N ,arr1)){
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);

    }
    public static boolean binarity(int target , int size ,int[] arr1){
        int left =0;
        int right = size-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr1[mid]==target){
                return true;
            }else if(arr1[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}

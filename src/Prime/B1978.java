package Prime;
import java.util.*;
import java.io.*;


public class B1978 {
    static int m ;
    static int[] nums;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        StringTokenizer line = new StringTokenizer(br.readLine());
        nums = new int[m];
        for(int i=0; i<m; i++){
            nums[i]=Integer.parseInt(line.nextToken());
        }
        HashSet<Integer> result = new HashSet<>();
        for(int num : nums){
            if(isPrime(num)){
                result.add(num);
            };
        }
        System.out.println(result.size());

    }

    public static boolean isPrime(int n){

        if(n == 0) return false;
        if(n == 1) return false;
        if(n ==2 )return true;
        if(n %2==0)return false;

        for(int i =3; i*i<=n; i+=2){
            if(n % i ==0) return false;
        }
        return true;
    }
}

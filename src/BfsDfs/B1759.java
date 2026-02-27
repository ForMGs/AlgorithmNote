package BfsDfs;
import java.util.*;
import java.io.*;

public class B1759 {
    static int m;
    static int n;
    static char[] pick;
    static char[] nums = new char[15];
    static int countJa =0;
    static int countMo =0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        pick = new char[m];
        StringTokenizer line = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = line.nextToken().charAt(0);
        }
        Arrays.sort(nums,0,n);
        Dfs(0,0);
        System.out.println(sb);
    }
    public static void Dfs(int start, int dept){

        if(dept == m ){
            if(!(countMo >=1 && countJa>=2)) return;
            for(int i =0; i < m; i++){
                sb.append(pick[i]).append(i==m-1 ? "\n":"");

            }
            return;
        }

        for(int i = start; i < n; i++){
            if("aeiou".indexOf(nums[i])>-1){
                countMo ++;
            }else{
                countJa ++;
            }
            pick[dept] = nums[i];
            Dfs(i+1 ,dept+1 );
            if("aeiou".indexOf(nums[i])>-1){
                countMo --;
            }else{
                countJa --;
            }
        }
    }
}

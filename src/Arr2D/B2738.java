package Arr2D;
import java.util.*;
import java.io.*;

public class B2738 {

    static int n,m;
    static int[][] result;
    ;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        result = new int[n][m];
        int i =0;
        while(i<2){
            for(int x = 0; x<n; x++){
                StringTokenizer arr = new StringTokenizer(br.readLine());
                for(int y=0; y<m; y++){
                    result[x][y] += Integer.parseInt(arr.nextToken());
                }
            }
            i++;
        }
        StringBuilder answer = new StringBuilder();
        for(int z=0; z<n; z++){
            for(int k=0; k<m; k++){
                answer.append(result[z][k]);
                answer.append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}

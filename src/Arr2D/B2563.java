package Arr2D;
import java.util.*;
import java.io.*;

public class B2563 {
    static int m;
    static int count=0;
    public static void main(String[] args)throws Exception{
        boolean[][] map = new boolean[100][100];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j =y; j < y+10; j++ ){

                for(int k=x; k<x+10; k++){

                    if(map[j][k])continue;
                    count++;
                    map[j][k]=true;
                }
            }
        }
        System.out.println(count);
    }
}

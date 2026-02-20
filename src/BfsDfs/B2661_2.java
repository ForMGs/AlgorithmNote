package BfsDfs;

import java.util.*;
import java.io.*;
public class B2661_2 {
    static int low;
    static int[][] map;
    static int[] x ={-1, 0 ,1 ,0};
    static int[] y= {0 , -1,0,1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        low = Integer.parseInt(br.readLine());

        for(int i = 0; i < low; i++){
            String line = br.readLine();

            for(int j=0; j < low; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

    }
}

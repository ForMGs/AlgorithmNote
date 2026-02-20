package BfsDfs;
import java.util.*;
import java.io.*;

public class B2606 {
    static int m; //컴터 수
    static int n; //연결 수
    static boolean[][] network;
    static int insect;
    static boolean[] insects;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st2.nextToken());

        network = new boolean[m][m];
        insects = new boolean[m];
        for(int i = 0; i <n; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(line.nextToken());
            int y = Integer.parseInt(line.nextToken());

            network[x-1][y-1] =true;
            network[y-1][x-1] =true;
        }

        insects[0]=true;
        Dfs(0);
        System.out.println(insect);
    }

    public static void Dfs(int idx){

        for(int k=0; k<m;k++){
            if(network[idx][k] && !insects[k]){
                insect++;
                insects[k] =true;
                Dfs(k);
            }
        }
    }
}

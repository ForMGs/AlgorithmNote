package Implementation;

import java.util.*;
import java.io.*;

public class B10809 {

    static int[] result ;
    static boolean[] added;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();
        result = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
        added = new boolean[26];



        for(int i=0; i<length; i++){
            char word = s.charAt(i);

            int idx = word -'a';
            if(added[idx]) continue;
            result[idx] = (i);
            added[idx]=true;
        }

        StringBuffer x = new StringBuffer();

        for(int k : result){
            x.append(k);
            x.append(" ");
        }
        System.out.println(x.toString());
    }
}

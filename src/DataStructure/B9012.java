package DataStructure;
import java.util.*;
import java.io.*;
import java.util.stream.*;
public class B9012 {
    static int m;
    static String[] result;
    public static void main(String[] args) throws Exception{
        /*
        * ) -> return false
        * (())() -> 0이면 return true
        * (()()() -> 1이면 return false
        * (()()()))-> 0인데 ) 는 return false
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        result = new String[m];

        for(int i =0; i<m; i++){
            int check =0;
            boolean skip =false;
            String line = br.readLine();
            int length = line.length();
            if(line.charAt(0) == ')'){
                result[i]= "NO";
                continue;
            }
            for(int j=0; j <length; j++){
                char idx = line.charAt(j);
                if(idx == '('){
                    check++;
                }else{
                    if(check ==0){
                        check--;
                        break;
                    }
                    check--;
                }

            }

            if(check==0){
                result[i]="YES";
            }else{
                result[i]="NO";
            }
        }
        for(int i=0; i<m; i++){
            System.out.println(result[i]);
        }
    }
}

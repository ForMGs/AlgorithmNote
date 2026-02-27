package DataStructure;
import java.util.*;
import java.io.*;

public class B4949 {
    static StringBuilder result = new StringBuilder();
    static int check1;
    static int check2;
    static boolean skip;

    public static void main(String[] args) throws Exception{
        //우선순위 관리 ( [
        //+- 관리 용 2개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            Deque<Character> stackQ = new ArrayDeque<>();

            String line = br.readLine();
//            check1=0;
//            check2=0;
            skip = false;

//            if(line.charAt(0)=='.') break;
            if(line.equals(".")) break;
            if(result.length() > 0){
                result.append("\n");
            }
            for(int i =0; i<line.length(); i++){
                if(line.charAt(i)=='(' || line.charAt(i)=='['){
                    stackQ.addLast(line.charAt(i));
//                    if(line.charAt(i)=='('){
//                        check1 ++;
//                    }else{
//                        check2 ++;
//                    }
                }else if(line.charAt(i)==')' || line.charAt(i)==']'){
//                    if(check1==0 && check2==0){
//                        result.append("no");
//                        skip = true;
//                        break;
//                    }
                    if(stackQ.isEmpty()){
                        result.append("no");
                        skip = true;
                        break;
                    }
                    char top = stackQ.removeLast();
                    if((line.charAt(i)==')' && top!='(')||
                            (line.charAt(i)==']' && top!='[')){
                        result.append("no");
                        skip=true;
                        break;
                    }
//                    {
//                        if(line.charAt(i)==')'){
//                            check1 --;
//                        }else{
//                            check2 --;
//                        }
//                    }else{
//                        result.append("no");
//                        skip = true;
//                        break;
//                    }

                }else{

                }

            }
            if(!skip){
//                if(check1 ==0 && check2==0){
//                    result.append("yes");
//                }else{
//                    result.append("no");
//                }
                if(stackQ.isEmpty()) result.append("yes");
                else result.append("no");
            }
        }
        System.out.println(result);
    }
}

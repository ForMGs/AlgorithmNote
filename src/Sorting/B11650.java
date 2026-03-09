package Sorting;
import java.util.*;
import java.io.*;
public class B11650 {
    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<int[]> set = new TreeSet<>((a,b)->{
            int absX1 = Math.abs(a[0]);
            int absX2 = Math.abs(b[0]);
            /// 절댓값 다름 .
            if(absX1 != absX2){
                return a[0]-b[0];
            }else{
                /// 절댓값이 같음.
                if(a[0]==b[0]){
                    /// 값도 같으면 y축 비교.
                    int absY1 = Math.abs(a[1]);
                    int absY2 = Math.abs(b[1]);
                    /// 절댓값 다름.
                    if(absY1 != absY2){
                        return a[1]-b[1];
                    }else{
                        if(a[1]>0){
                            /// a가 양수 b가 음수
                            return 1;
                        }else{
                            return -1;
                        }
                    }
                }else{
                    if(a[0]>0){
                        /// a가 양수 b가 음수
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            set.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        for(int[] dir : set){
            System.out.println(dir[0]+" "+dir[1]);
        }
    }
}

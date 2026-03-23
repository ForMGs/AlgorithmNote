package Sorting;
import java.util.*;
import java.io.*;
public class B25305 {

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] option = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted((a,b)->b-a)
                .skip(option[1]-1)
                .limit(1)
                .forEach(System.out::println);

    }
}

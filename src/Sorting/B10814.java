package Sorting;
import java.util.*;
import java.io.*;

public class B10814 {
    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> arr= new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Student(Integer.parseInt(st.nextToken()),st.nextToken()));
        }
        arr.sort(Comparator.comparingInt(s->s.age));
        for(Student s : arr){
            System.out.println(s.age+" "+s.name);
        }

    }
    static class Student{
        int age ;
        String name;
        Student(int age, String name){
            this.age = age;
            this.name =name;
        }
    }
    
}

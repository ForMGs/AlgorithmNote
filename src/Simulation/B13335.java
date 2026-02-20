package Simulation;
import java.util.*;
import java.io.*;

/*
* 강을 가로지르는 하나의 차선으로 된 다리가 하나 있다. 이 다리를 n 개의 트럭이 건너가려고 한다. 트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 서로 같지 않을 수 있다.
* 다리 위에는 단지 w 대의 트럭만 동시에 올라갈 수 있다. 다리의 길이는 w 단위길이(unit distance)이며, 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다고 가정한다.
* 동시에 다리 위에 올라가 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다. 참고로, 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산할 때 포함하지 않는다고 가정한다.

예를 들어, 다리의 길이 w는 2, 다리의 최대하중 L은 10, 다리를 건너려는 트럭이 트럭의 무게가 [7, 4, 5, 6]인 순서대로 다리를 오른쪽에서 왼쪽으로 건넌다고 하자.
*  이 경우 모든 트럭이 다리를 건너는 최단시간은 아래의 그림에서 보는 것과 같이 8 이다.

다리의 길이와 다리의 최대하중, 그리고 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때, 모든 트럭이 다리를 건너는 최단시간을 구하는 프로그램을 작성하라.*/
public class B13335 {


    public static void main(String[] agrs) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trucks[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new ArrayDeque<>();
        // 다리 길이만큼 0으로 초기화 (처음엔 빈 다리)
        for (int i = 0; i < w; i++) bridge.add(0);

        int time = 0;
        int sumWeight = 0;
        int idx = 0; // 다음으로 올릴 트럭 인덱스

        while (idx < n) {
            // 1초 경과: 한 칸 전진 (맨 앞 트럭/0 내려감)
            time++;
            sumWeight -= bridge.poll();

            // 다음 트럭을 올릴 수 있으면 올리고, 아니면 0(빈칸) 올림
            if (sumWeight + trucks[idx] <= L) {
                bridge.add(trucks[idx]);
                sumWeight += trucks[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        // 마지막 트럭이 다리에 올라간 뒤, 다리 길이만큼 더 지나야 완전히 내려감
        time += w;

        System.out.println(time);
    }

}

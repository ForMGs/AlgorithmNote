package BfsDfs;

import java.util.*;
import java.io.*;

public class B6603 {
    static int k;
    static int[] arr = new int[13];
    static int[] pick = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    // depth: 지금까지 뽑은 개수, start: 다음에 뽑기 시작할 인덱스
    static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(pick[i]).append(i == 5 ? '\n' : ' ');
            }
            return;
        }

        for (int i = start; i < k; i++) {
            pick[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}

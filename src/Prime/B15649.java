package Prime;
import java.util.*;
import java.io.*;
public class B15649 {
    static int m, n;
    static boolean[] used;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        used = new boolean[m + 1];   // 1..m 사용
        pick = new int[n];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(pick[i]).append(i == n - 1 ? '\n' : ' ');
            }
            return;
        }

        for (int i = 1; i <= m; i++) {
            if (used[i]) continue;
            used[i] = true;
            pick[depth] = i;
            dfs(depth + 1);
            used[i] = false;
        }
    }
}

package BfsDfs;
import java.io.*;
import java.util.*;

public class B7575 {

    static int N, K;
    static int[][] programs;
    static int[] lengths;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        programs = new int[N][];
        lengths = new int[N];

        int baseIdx = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int m = Integer.parseInt(br.readLine());
            lengths[i] = m;
            programs[i] = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                programs[i][j] = Integer.parseInt(st.nextToken());
            }

            if (m < minLen) {
                minLen = m;
                baseIdx = i;
            }
        }

        int[] base = programs[baseIdx];

        // 기준 프로그램의 모든 길이 K 구간을 후보로 확인
        for (int start = 0; start <= base.length - K; start++) {
            int[] pattern = new int[K];
            for (int i = 0; i < K; i++) {
                pattern[i] = base[start + i];
            }

            int[] reversed = reverse(pattern);

            boolean possible = true;

            for (int i = 0; i < N; i++) {
                if (i == baseIdx) continue;

                if (!kmpSearch(programs[i], pattern) && !kmpSearch(programs[i], reversed)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    static int[] reverse(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    static boolean kmpSearch(int[] text, int[] pattern) {
        int[] pi = makePi(pattern);
        int j = 0;

        for (int i = 0; i < text.length; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (text[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }

        return false;
    }

    static int[] makePi(int[] pattern) {
        int[] pi = new int[pattern.length];
        int j = 0;

        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
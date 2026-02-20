package Simulation;
import java.util.*;
import java.io.*;

public class B14891 {

    public class Main {
        static int[][] gear = new int[4][8];

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 입력: 4줄(각 8자리 0/1 문자열)
            for (int i = 0; i < 4; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < 8; j++) {
                    gear[i][j] = s.charAt(j) - '0';
                }
            }

            int k = Integer.parseInt(br.readLine().trim());

            for (int t = 0; t < k; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1; // 0-based
                int dir = Integer.parseInt(st.nextToken());     // 1: 시계, -1: 반시계

                int[] rot = new int[4];
                rot[idx] = dir;

                // 오른쪽 전파
                for (int i = idx; i < 3; i++) {
                    if (gear[i][2] != gear[i + 1][6]) rot[i + 1] = -rot[i];
                    else break;
                }

                // 왼쪽 전파
                for (int i = idx; i > 0; i--) {
                    if (gear[i][6] != gear[i - 1][2]) rot[i - 1] = -rot[i];
                    else break;
                }

                // 회전 적용
                for (int i = 0; i < 4; i++) rotate(i, rot[i]);
            }

            int score = 0;
            if (gear[0][0] == 1) score += 1;
            if (gear[1][0] == 1) score += 2;
            if (gear[2][0] == 1) score += 4;
            if (gear[3][0] == 1) score += 8;

            System.out.println(score);
        }

        static void rotate(int idx, int dir) {
            if (dir == 0) return;

            if (dir == 1) { // 시계
                int tmp = gear[idx][7];
                for (int i = 7; i > 0; i--) gear[idx][i] = gear[idx][i - 1];
                gear[idx][0] = tmp;
            } else { // 반시계
                int tmp = gear[idx][0];
                for (int i = 0; i < 7; i++) gear[idx][i] = gear[idx][i + 1];
                gear[idx][7] = tmp;
            }
        }
    }
}

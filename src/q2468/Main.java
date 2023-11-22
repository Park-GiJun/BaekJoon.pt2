package q2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] town;
    static boolean[][] visited;
    static boolean[][] drown;

    static void dfs(int a, int b, int height) {
        if (a < 0 || b < 0 || a >= n || b >= n || visited[a][b] || drown[a][b] || town[a][b] <= height) {
            return;
        }
        visited[a][b] = true;
        dfs(a + 1, b, height);
        dfs(a - 1, b, height);
        dfs(a, b + 1, height);
        dfs(a, b - 1, height);
    }

    static void reset(boolean[][] s) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        town = new int[n][n];
        visited = new boolean[n][n];
        drown = new boolean[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int inp = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(inp, maxHeight);
                town[i][j] = inp;
            }
        }

        int maxSafeAreas = 0;

        for (int height = 0; height <= maxHeight; height++) {
            int count = 0;
            reset(visited);
            reset(drown);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && town[i][j] > height && !drown[i][j]) {
                        dfs(i, j, height);
                        count++;
                    }
                }
            }

            maxSafeAreas = Math.max(maxSafeAreas, count);
        }

        System.out.println(maxSafeAreas);
    }
}

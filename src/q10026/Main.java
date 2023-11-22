package q10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static String[][] rgb;
    static String[][] redGreen;
    static boolean[][] visited;

    static void dfs(int a, int b) {
        if (a == 0 || b == 0 || a > n || b > n || visited[a][b]) {
            return;
        }
        visited[a][b] = true;

        dfs(a + 1, b);
        dfs(a - 1, b);
        dfs(a, b + 1);
        dfs(a, b - 1);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        rgb = new String[n][n];
        redGreen = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String inp = br.readLine();
            for (int j = 0; j < n; j++) {
                rgb[i][j] = String.valueOf(inp.charAt(j));
                visited[i][j] = false;
            }
        }


    }
}

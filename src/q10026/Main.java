package q10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n; // n*n 배열
    static String[][] rgb; // 그림의 RGB위치
    static String[][] rgb2; // 그림의 RGB위치
    static boolean[][] visited; // 방문 여부
    static boolean[][] visited2; // 방문 여부

    static void dfs(int a, int b, String color) {
        if (a < 0 || a >= n || b < 0 || b >= n || visited[a][b] || !rgb[a][b].equals(color)) {
            return;
        }

        visited[a][b] = true;

        dfs(a + 1, b, color);
        dfs(a - 1, b, color);
        dfs(a, b + 1, color);
        dfs(a, b - 1, color);
    }

    static void dfs2(int a, int b, String color) {
        if (a < 0 || a >= n || b < 0 || b >= n || visited2[a][b] || !rgb2[a][b].equals(color)) {
            return;
        }

        visited2[a][b] = true;

        dfs2(a + 1, b, color);
        dfs2(a - 1, b, color);
        dfs2(a, b + 1, color);
        dfs2(a, b - 1, color);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        rgb = new String[n][n];
        rgb2=new String[n][n];
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String inpRGB = br.readLine();
            for (int j = 0; j < n; j++) {
                char char1 = inpRGB.charAt(j);
                rgb[i][j] = String.valueOf(char1);
                if (char1 == 'R' || char1 =='G') {
                    char1 = 'A';
                }
                rgb2[i][j] = String.valueOf(char1);
            }
        }

        int count = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, rgb[i][j]);
                    count++;
                }
                if (!visited2[i][j]) {
                    dfs2(i, j, rgb2[i][j]);
                    count2++;
                }
            }
        }
        System.out.println(count + " " + count2);
    }
}
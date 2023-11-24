package q15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] ints;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int a, int b, int c) {
        if (c == b) {
            for (int add : ints) {
                sb.append(add).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < a; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ints[c] = i + 1;
                dfs(a, b, c + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ints = new int[m];
        visit = new boolean[n];
        dfs(n, m, 0);
        System.out.println(sb.toString());

    }
}

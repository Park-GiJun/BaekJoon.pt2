package q11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, m, count;
    static boolean[] visited;
    static ArrayList<Integer>[] check;

    static void dfs(int c) {
        if (visited[c]) {
            return;
        }
        visited[c] = true;
        for (int i : check[c]) {
            dfs(i);
        }
    }

    public static void main(String[] args) throws Exception {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 간선의 수

        visited = new boolean[n + 1]; // 방문 배열
        check = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            check[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a].add(b);
            check[b].add(a);
        }

        count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}

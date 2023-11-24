package q15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] ints;
    static StringBuilder sb = new StringBuilder();
    static Set<String> resultSet = new HashSet<>();

    static void dfs(int a, int b, int c, int startIndex) {
        if (c == b) {
            StringBuilder currentPermutation = new StringBuilder();
            for (int i = 0; i < b; i++) {
                currentPermutation.append(ints[i]).append(" ");
            }

            String permutationString = currentPermutation.toString().trim();

            if (resultSet.contains(permutationString)) {
                return;
            }

            resultSet.add(permutationString);
            sb.append(permutationString).append("\n");

            return;
        }
        for (int i = startIndex; i < a; i++) {
            ints[c] = i + 1;
            dfs(a, b, c + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ints = new int[m];
        dfs(n, m, 0, 0);
        System.out.println(sb.toString());
    }
}


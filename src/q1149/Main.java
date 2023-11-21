package q1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] arr2 = new int[n + 1][3];
        arr2[0][0] = arr[0][0];
        arr2[0][1] = arr[0][1];
        arr2[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            arr2[i][0] = Math.min(arr2[i - 1][1], arr2[i - 1][2]) + arr[i][0];
            arr2[i][1] = Math.min(arr2[i - 1][0], arr2[i - 1][2]) + arr[i][1];
            arr2[i][2] = Math.min(arr2[i - 1][0], arr2[i - 1][1]) + arr[i][2];
        }
        System.out.print(Math.min(Math.min(arr2[n - 1][0], arr2[n - 1][1]), arr2[n - 1][2]));
    }
}

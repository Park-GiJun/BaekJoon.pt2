package q9663;

import java.io.*;

public class Main {

    static int n;
    static int count;
    static int[][] chessBoard;
    static boolean[][] conqueredByQueen;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        count = 0;


        chessBoard = new int[n][n];
        conqueredByQueen = new boolean[n][n];


    }
}

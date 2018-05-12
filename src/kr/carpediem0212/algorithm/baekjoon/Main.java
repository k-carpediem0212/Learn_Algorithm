package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static char[][] matrix;
	public static int[][] cache;

	public static int getMaxSquareSize() {
		int max = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (matrix[i][j] == '1') {
					cache[i][j] = min(cache[i - 1][j - 1], cache[i - 1][j], cache[i][j - 1]) + 1;
				}

				max = Integer.max(max, cache[i][j]);
			}
		}

		return max * max;
	}

	public static int min(int num1, int num2, int num3) {
		int temp = (num1 < num2) ? num1 : num2;

		return (temp < num3) ? temp : num3;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			matrix = new char[n + 1][m + 1];
			cache = new int[n + 1][m + 1];

			for (int i = 1; i <= n; i++) {
				String row = br.readLine();
				for (int j = 1; j <= m; j++) {
					matrix[i][j] = row.charAt(j - 1);
				}
			}

			System.out.println(getMaxSquareSize());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

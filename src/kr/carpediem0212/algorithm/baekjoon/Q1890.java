package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1890 {
	private int[][] map;
	private int n;
	private long[][] cache;

	public Q1890(int n, int[][] map) {
		this.map = map;
		this.n = n;
		this.cache = new long[n][n];
	}

	public long jump() {
		cache[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int next = map[i][j];

				if (i == (n - 1) && j == (n - 1)) {
					continue;
				}

				if ((i + next) < n) {
					cache[i + next][j] += cache[i][j];
				}

				if ((j + next) < n) {
					cache[i][j + next] += cache[i][j];
				}
			}
		}

		return cache[n - 1][n - 1];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Q1890 m = new Q1890(n, map);
			System.out.println(m.jump());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

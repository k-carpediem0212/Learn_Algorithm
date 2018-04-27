package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int n;
	private int m;
	private int[][] rooms;
	private int[][] cache;

	public Main(int n, int m, int[][] rooms) {
		this.n = n;
		this.m = m;
		this.rooms = rooms;
		this.cache = new int[n + 1][m + 1];
	}

	public int escape() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1) {
					cache[i][j] = rooms[i - 1][j - 1] + cache[i][j - 1];
				} else if (j == 1) {
					cache[i][j] = rooms[i - 1][j - 1] + cache[i - 1][j];
				} else {
					cache[i][j] = rooms[i - 1][j - 1] + Integer.max(cache[i][j - 1], cache[i - 1][j]);
				}
			}
		}

		return cache[n][m];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] rooms = new int[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Main _m = new Main(n, m, rooms);
			System.out.println(_m.escape());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

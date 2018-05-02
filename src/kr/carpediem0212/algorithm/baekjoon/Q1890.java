package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *
 *	------------------------------------------------
 *	조건 :
 *		1. 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다.
 *	------------------------------------------------
 *	
 *	처음 DFS를 이용하였으나 시간 초과가 발생하여 DP를 이용하여 해결
 *	
 *	모든 배열을 순회하며, 자신이 방문할 수 있는 노드에 자신까지 올 수 있는 경우의 수를 + 해줌
 *
 *	[점화식]
 *		if ((i + next) < n) {
 *			cache[i + next][j] += cache[i][j];
 *		}
 *
 *		if ((j + next) < n) {
 *			cache[i][j + next] += cache[i][j];
 *		}
 *    
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */

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

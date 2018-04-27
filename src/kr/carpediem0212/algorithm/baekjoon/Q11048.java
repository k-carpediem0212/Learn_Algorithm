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
 *		1. (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있다.
 *		2. 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다.
 *		3. 미로 밖으로 나갈 수는 없다.
 *	------------------------------------------------
 *	
 *	(i,j) 방까지 올 때 사탕을 최대한으로 가져오기 위해서는 대각선 방향 이동은 고려하지 않는다.
 *	위의 조건 1에서 (r+1, c), (r, c+1)에 대해서만 고려하며,
 *	현재 위치로 오는 경우는
 *		1. (r-1, c)에서 오는 경우
 *		2. (r, c-1)에서 오는 경우
 *	가 존재한다.
 *
 *	위를 토대로 점화식은 아래와 같다.
 *	[점화식]
 *		if (i == 1) {
 *			cache[i][j] = rooms[i - 1][j - 1] + cache[i][j - 1];
 * 		} else if (j == 1) {
 *			cache[i][j] = rooms[i - 1][j - 1] + cache[i - 1][j];
 *		} else {
 *			cache[i][j] = rooms[i - 1][j - 1] + Integer.max(cache[i][j - 1], cache[i - 1][j]);
 *		}
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q11048 {
	private int n;
	private int m;
	private int[][] rooms;
	private int[][] cache;

	public Q11048(int n, int m, int[][] rooms) {
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

			Q11048 _m = new Q11048(n, m, rooms);
			System.out.println(_m.escape());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

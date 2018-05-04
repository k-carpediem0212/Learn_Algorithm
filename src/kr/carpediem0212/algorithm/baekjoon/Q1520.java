package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
 *	------------------------------------------------
 *	
 *	DP를 이용하여 해결
 *	현재위치에서부터 가능한 경로들을 탐색하여 반환
 *	완전탐색에 메모리제이션을 적용
 *		
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : 
 *  ---------------------------
 */
public class Q1520 {
	public static int m;
	public static int n;
	public static int[][] matrix;
	public static int[][] cache;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };

	public static int search(int y, int x) {
		if (y == (m - 1) && x == (n - 1)) {
			return 1;
		}

		if (cache[y][x] != -1) {
			return cache[y][x];
		}

		int ret = 0;

		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];

			if (nextY < 0 || nextX < 0 || nextY >= m || nextX >= n) {
				continue;
			}

			if(matrix[nextY][nextX] < matrix[y][x]) {
				ret += search(nextY, nextX);	
			}
		}

		cache[y][x] = ret;
		return ret;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			matrix = new int[m][n];
			cache = new int[m][n];
			for(int i = 0; i < m; i++) {
				Arrays.fill(cache[i], -1);
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println(search(0, 0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

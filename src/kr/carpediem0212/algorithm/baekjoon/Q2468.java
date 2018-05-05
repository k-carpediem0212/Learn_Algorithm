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
 *	1 ~ 100까지 수위에 대해
 *	안전 구역을 확인하여 최대 값을 반환
 *
 *	입력 범위는 1 ~ 100이지만
 *	실제 가장 높은 수위 일 경우 전부가 잠기므로
 *
 *	1~100이 아닌 1~max 값까지만 확인
 *	
 *  ---------------------------
 *  공간복잡도 : 
 *  시간복잡도 : 
 *  ---------------------------
 */
public class Q2468 {
	public static int n;
	public static int[][] matrix;
	public static boolean[][] isVisit;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };
	public static int max;
	
	public static int getSafeArea() {
	
		int maxOfArea = 0;
		
		for (int i = 0; i < max; i++) {
			int cnt = 0;
			
			for (int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(matrix[j][k] > i && isVisit[j][k] == false) {
						dfs(j, k, i);
						cnt++;
					}
				}
			}
			
			for(int j =0; j < n; j++) {
				Arrays.fill(isVisit[j], false);
			}
			
			if(cnt > maxOfArea) {
				
				maxOfArea = cnt;
			}
		}
		
		return maxOfArea;
	}

	public static void dfs(int y, int x, int criteria) {
		isVisit[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];

			if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
				continue;
			}
			
			if(matrix[nextY][nextX] > criteria && isVisit[nextY][nextX] == false) {
				dfs(nextY, nextX, criteria);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			matrix = new int[n][n];
			isVisit = new boolean[n][n];

			max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					
					if(matrix[i][j] > max) {
						max = matrix[i][j];
					}
				}
			}
			
			System.out.println(Q2468.getSafeArea());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

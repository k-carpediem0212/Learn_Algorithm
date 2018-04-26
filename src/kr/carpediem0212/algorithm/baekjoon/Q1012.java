package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *
 *	------------------------------------------------
 *	조건 :
 *		조건 1. 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
 *	------------------------------------------------
 *	
 *	farm 배열을 순회하면서 1인 값을 찾고
 *	그 값을 기준으로 dfs 수행 을 반복하여
 *	전체 지렁이 개수를 구한다.
 *
 *  ---------------------------
 *  공간복잡도 : O(1)
 *  시간복잡도 : O(n^3)
 *  ---------------------------
 */
public class Q1012 {
	private static int m;
	private static int n;
	private static int numOfPlant;
	private static int[][] farm;
	private static int[] coordinateX = { 0, 0, 1, -1 };
	private static int[] coordinateY = { 1, -1, 0, 0 };

	public static int put() {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (farm[i][j] == 1) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		
		return cnt;
	}

	public static void dfs(int y, int x) {
		farm[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int nextY = y + coordinateY[i];
			int nextX = x + coordinateX[i];

			if(nextX < 0 || nextY < 0 || nextX >= m || nextY >=n) {
				continue;
			}
			
			if (farm[nextY][nextX] == 1) {
				dfs(nextY, nextX);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			while ((numOfTestCase--) > 0) {
				String[] inputDatas = br.readLine().trim().split("\\s+");
				m = Integer.parseInt(inputDatas[0]);
				n = Integer.parseInt(inputDatas[1]);
				numOfPlant = Integer.parseInt(inputDatas[2]);
				farm = new int[n][m];

				for (int i = 0; i < numOfPlant; i++) {
					String[] plantDatas = br.readLine().trim().split("\\s+");
					int x = Integer.parseInt(plantDatas[0]);
					int y = Integer.parseInt(plantDatas[1]);
					
					farm[y][x] = 1;
				}

				System.out.println(Q1012.put());
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


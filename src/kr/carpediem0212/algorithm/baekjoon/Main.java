package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

				System.out.println(Main.put());
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


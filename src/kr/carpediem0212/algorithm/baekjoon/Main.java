package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private int[][] stickers;
	private int n;
	private int[][] cache;

	public Main(int n, int[][] stickers) {
		this.n = n;
		this.stickers = stickers;
		this.cache = new int[2][n + 1];
	}

	public int maxValue() {
		cache[0][1] = stickers[0][0];
		cache[1][1] = stickers[1][0];
		
		for(int i = 2; i <= n; i++) {
			cache[0][i] = stickers[0][i - 1] + Integer.max(cache[1][i - 1], Integer.max(cache[0][i - 2], cache[1][i - 2]));
			cache[1][i] = stickers[1][i - 1] + Integer.max(cache[0][i - 1], Integer.max(cache[0][i - 2], cache[1][i - 2]));
			
		}
		
		return Integer.max(cache[0][n], cache[1][n]);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			while ((numOfTestCase--) > 0) {
				int n = Integer.parseInt(br.readLine().trim());
				int[][] stickers = new int[2][n];

				for (int i = 0; i < 2; i++) {
					String[] inputDatas = br.readLine().trim().split("\\s+");
					
					for (int j = 0; j < n; j++) {
						stickers[i][j] = Integer.parseInt(inputDatas[j]);
					}
				}

				Main m = new Main(n, stickers);
				System.out.println(m.maxValue());
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

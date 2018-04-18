package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private int[] valueOfSet;
	private int[][] cache;
	private int numOfBread;

	public Main(int numOfBread, int[] valueOfSet) {
		this.numOfBread = numOfBread;
		this.valueOfSet = valueOfSet;
		this.cache = new int[valueOfSet.length + 1][valueOfSet.length + 1];
	}

	public int sell() {
		for (int i = 1; i <= numOfBread; i++) {
			for (int j = 1; j <= numOfBread; j++) {
				if (j >= i) {
					cache[i][j] = Integer.max(cache[i - 1][j], (cache[i][j - i] + valueOfSet[i - 1]));
				} else {
					cache[i][j] = cache[i - 1][j]; 
				}
			}
		}
		
		/*
		for (int i = 0; i <= numOfBread; i++) {
			System.out.println(Arrays.toString(cache[i]));
		}
		*/
		
		return cache[numOfBread][numOfBread];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfBread = Integer.parseInt(br.readLine().trim());
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int[] valueOfSet = new int[inputDatas.length];

			for (int i = 0; i < inputDatas.length; i++) {
				valueOfSet[i] = Integer.parseInt(inputDatas[i]);
			}

			Main m = new Main(numOfBread, valueOfSet);
			System.out.println(m.sell());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

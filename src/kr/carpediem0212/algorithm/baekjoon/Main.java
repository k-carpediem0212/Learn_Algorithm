package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private int[] wines;
	private int[] cache;
	private int numOfWine;
	
	public Main(int[] wines, int numOfWine) {
		this.wines = wines;
		this.cache = new int[numOfWine + 1];
		this.numOfWine = numOfWine;
	}
	
	public int drink() {
		if(numOfWine == 1) {
			return wines[1];
		} else if (numOfWine == 2) {
			return wines[2] + wines[1];
		}
		
		cache[1] = wines[1];
		cache[2] = wines[2] + wines[1];
		
		for(int i = 3; i <= numOfWine; i++) {
			// 1. i를 안마실 경우
			int max = cache[i - 1];
			// 2. i를 마시고 (i-1)을 마시지 않을 경우
			max = Integer.max(max, (wines[i] + cache[i - 2]));
			// 3. i를 마시고 (i-1)을 마실 경우
			max = Integer.max(max, (wines[i] + wines[i-1] + cache[i - 3]));
			
			cache[i] = max;
		}
		
		return cache[numOfWine];
	}

	/*
	public void drink() {
		if(numOfWine == 1) {
			//return wines[0];
			System.out.println(wines[0]);
		} else if (numOfWine == 2) {
			//return wines[0] + wines[1];
			System.out.println(wines[1]);
		}
		
		cache[0][0] = wines[0];
		cache[1][0] = wines[0];
		cache[0][1] = wines[0] + wines[1];
		cache[1][1] = wines[1];
		
		int max = 0;
		for(int i = 2; i < numOfWine; i++) {
			cache[0][i] = wines[i] + cache[1][i - 1];
			cache[1][i] = wines[i] + Integer.max(cache[0][i - 2], cache[1][i - 2]);
			
			int cur = Integer.max(cache[0][i], cache[1][i]);
			if (max < cur) {
				max = cur;
			}
		}
		
		System.out.println(max);
	}*/

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfWine = Integer.parseInt(br.readLine().trim());
			int[] wines = new int[numOfWine + 1];
			
			for(int i = 1; i <= numOfWine; i++) {
				wines[i] = Integer.parseInt(br.readLine().trim());
			}
			
			Main m = new Main(wines, numOfWine);
			System.out.println(m.drink());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
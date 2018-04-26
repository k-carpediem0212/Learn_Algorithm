package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private int n;
	private int k;
	private int[] coins;
	private int[] cache;

	public Main(int n, int k, int[] coins) {
		this.n = n;
		this.k = k;
		this.coins = coins;
		this.cache = new int[k + 1];
		
		Arrays.sort(coins);
		Arrays.fill(cache, 100001);
		cache[0] = 0;
		
	}

	public int exchange() {
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				cache[j] = Integer.min(cache[j], cache[j - coins[i]] + 1);
			}
		}
		
		if(cache[k] == 100001) {
			return -1;
		}
		
		return cache[k];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(inputDatas[0]);
			int k = Integer.parseInt(inputDatas[1]);
			int[] coins = new int[n];
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(br.readLine().trim());
			}
			
			Main m = new Main(n, k, coins);
			System.out.println(m.exchange());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

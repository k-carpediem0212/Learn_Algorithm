package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private final int MOD = 10007;
	private int width;
	private int[] cache;
	
	public Main(int width) {
		this.width = width;
		this.cache = new int[width + 1];
	}
	
	public int tiling() {
		if(width == 1) {
			return 1;
		} else if(width == 2) {
			return 3;
		}
		
		cache[1] = 1;
		cache[2] = 3;
		
		for(int i = 3; i <= width; i++) {
			cache[i] = (cache[i - 1] + (2 * cache[i - 2])) % MOD;
		}
		
		return cache[width] % MOD;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int width = Integer.parseInt(br.readLine().trim());

			Main m = new Main(width);
			System.out.println(m.tiling());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

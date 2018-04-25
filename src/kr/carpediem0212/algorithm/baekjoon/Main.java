package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 *  10 + 9 + 8 + 7 + 5 + 4 + 3 + 2 + 1
 *  0  1  2  3  4  5  6  7  8  9
 *  1  1  1  1  1  1  1  1  1  1
 *  1  2  3  4  5  6  7  8  9  10
 *  1  3  6  10 15 21 28 36 45 55
 *  1  4  10 20 35 46 74 110 155 210
 * 
 */

public class Main {
	private final int MOD = 10007;
	private int[] cache;
	private int num;
	
	public Main(int num) {
		this.num = num;
		this.cache = new int[10];
	}
	
	public int increase() {
		Arrays.fill(cache, 1);
		
		for (int i = 2; i <= num; i++) {
			for( int j = 1; j <= 9; j++) {
				cache[j] = (cache[j - 1] + cache[j]) % MOD;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += cache[i] % MOD;
		}
		
		//System.out.println(Arrays.toString(cache));
		return sum % MOD;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int num = Integer.parseInt(br.readLine().trim());
			
			Main m = new Main(num);
			System.out.println(m.increase());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

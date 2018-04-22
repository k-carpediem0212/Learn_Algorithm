package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private int n;
	
	public Main(int n) {
		this.n = n;
	}
	
	public long getP() {
		if(n == 1 || n == 2 || n== 3) {
			return 1;
		}
		
		long[] cache = new long[n];
		
		cache[0] = 1;
		cache[1] = 1;
		cache[2] = 1;
		
		for(int i = 3; i < n; i++) {
			cache[i] = cache[i - 2] + cache[i - 3];
		}
		
		return cache[n - 1];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());
			
			while((numOfTestCase--) > 0) {
				int n = Integer.parseInt(br.readLine().trim());
				
				Main _m = new Main(n);
				System.out.println(_m.getP());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 
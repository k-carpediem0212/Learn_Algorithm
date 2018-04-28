package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public Main() {

	}

	public int tiling(int n) {
		if ((n % 2) != 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		}

		int[] cache = new int[n + 1];
		cache[0] = 1;
		cache[2] = 3;

		for (int i = 4; i <= n; i = i + 2) {
			cache[i] = cache[i - 2] * 3;
			
			for (int j = 4; j <= i; j = j + 2) {
				cache[i] += cache[i - j] * 2;
			}
		}

		return cache[n];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Main m = new Main();
			System.out.println(m.tiling(n));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

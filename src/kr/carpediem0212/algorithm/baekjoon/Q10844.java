package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {
	public Q10844() {
	}

	public long findStairNum(int lengthOfNum) {
		long[][] cache = new long[lengthOfNum + 1][10];

		for (int i = 1; i < 10; i++) {
			cache[1][i] = 1;
		}

		for (int i = 2; i <= lengthOfNum; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					cache[i][j] = cache[i - 1][j + 1] % 1000000000;
				} else if (j == 9) {
					cache[i][j] = cache[i - 1][j - 1] % 1000000000;
				} else {
					cache[i][j] = (cache[i - 1][j - 1] + cache[i - 1][j + 1]) % 1000000000;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += cache[lengthOfNum][i] % 1000000000;
		}

		return sum % 1000000000;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int lengthOfNum = Integer.parseInt(br.readLine().trim());

			Q10844 m = new Q10844();
			System.out.println(m.findStairNum(lengthOfNum));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 2 3 4 5 6 7 8 9 10 11
// 1 2 3 1 2 3 4 2 3 4  5
// 1 2 3 1 2 3 4 2 1 2  3
public class Main {
	public Main() {
	}

	public int presentSqrt(int num) {
		int[] cache = new int[num + 1];
		
		int sqrt = (int)Math.sqrt(num);
		
		for (int i = 1; i <= sqrt; i++) {
			int pow = i * i;

			for (int j = pow; j <= num; j++) {
				if (cache[j] != 0) {
					cache[j] = Math.min(cache[j], cache[j - pow] + 1);
				} else {
					cache[j] = cache[j - pow] + 1;
				}
			}
		}

		//System.out.println(Arrays.toString(cache));
		return cache[num];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			Main m = new Main();
			System.out.println(m.presentSqrt(num));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

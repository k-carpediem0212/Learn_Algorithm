package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *
 *	------------------------------------------------
 *	조건 :
 *		조건 1. 이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
 *		조건 2.  0으로 시작하는 수는 없다.
 *	------------------------------------------------
 *	
 *	N자리 계단 수의 수는 (N-1)자리의 계단 수들 뒤에 가능한 숫자를 붙여 만들 수 있다.
 *	마지막 자리에 올 수 있는 수에 대해 보면
 *		1일 경우, 0,2
 *		2일 경우, 1,3
 *	이다. 하지만,
 *		0일 경우, 1
 *		9일 경우, 8
 *	이다. 조건 식으로 이용해 위 식을 표현하면
 *
 *	[점화식]
 *		if (j == 0) {
 *			cache[i][j] = cache[i - 1][j + 1];
 *		} else if (j == 9) {
 *			cache[i][j] = cache[i - 1][j - 1];
 *		} else {
 *			cache[i][j] = (cache[i - 1][j - 1] + cache[i - 1][j + 1]);
 *		}
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */

public class Main {
	private final int MOD = 1000000000;
	
	public Main() {
	}

	public long findStairNum(int lengthOfNum) {
		// row는 자리 수, column은 맨 끝자리 수를 나타내는 배열 생성
		long[][] cache = new long[lengthOfNum + 1][10];

		for (int i = 1; i < 10; i++) {
			// 0으로 시작하는 수는 없으므로, 1부터 초기화
			cache[1][i] = 1;
		}

		for (int i = 2; i <= lengthOfNum; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					// 0은 이전 자리수가 1일 경우에만 가능
					cache[i][j] = cache[i - 1][j + 1] % MOD;
				} else if (j == 9) {
					// 9는 이전 자리수가 8일 경우에만 가능
					cache[i][j] = cache[i - 1][j - 1] % MOD;
				} else {
					cache[i][j] = (cache[i - 1][j - 1] + cache[i - 1][j + 1]) % MOD;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += cache[lengthOfNum][i];
		}

		return sum % MOD;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int lengthOfNum = Integer.parseInt(br.readLine().trim());

			Main m = new Main();
			System.out.println(m.findStairNum(lengthOfNum));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

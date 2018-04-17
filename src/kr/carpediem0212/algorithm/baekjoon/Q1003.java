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
 *		N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 *	------------------------------------------------
 *	
 *	fibonacci(3)일 경우, 아래와 같은 방식으로 피보나치 수열이 구해진다.
 *		fibonacci(3) = fibonacci(2) + fibonacci(1) = fibonacci(1) + fibonacci(0) + fibonacci(1)
 *	
 *	여기서,
 *	fibonacci(3)에서 fibonacci(0), fibonacci(1)의 호출 횟수는
 *		fibonacci(2)에서 fibonacci(0), fibonacci(1)호출 횟수와
 *		fibonacci(1)에서 fibonacci(0), fibonacci(1)호출 횟수의 합과 동일하다.
 *
 *	결국 피보나치 수열의 점화식과 동일하게 접근이 가능하다.
 *	
 *	[점화식] (fibo는 0,1의 호출 횟수를 구하는 함수)
 *		fibo(n) = fibo(n-1) + fibo(n-2)
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q1003 {
	private int[][] cache;

	public Q1003() {
	}

	public void fibo(int num) {
		// 0 부터 num까지 이므로 배열 크기를 +1 하여 생성
		this.cache = new int[2][num + 1];

		if (num == 0) {
			System.out.println("1 0");
			return;
		} else if (num == 1) {
			System.out.println("0 1");
			return;
		}
		
		// 0, 1에 대해 초기화
		cache[0][0] = 1;
		cache[1][0] = 0;
		cache[0][1] = 0;
		cache[1][1] = 1;

		for (int i = 2; i < (num + 1); i++) {
			cache[0][i] = cache[0][i - 1] + cache[0][i - 2];
			cache[1][i] = cache[1][i - 1] + cache[1][i - 2];
		}

		System.out.println(cache[0][num] + " " + cache[1][num]);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			while ((numOfTestCase--) > 0) {
				int num = Integer.parseInt(br.readLine().trim());
				
				Q1003 m = new Q1003();
				m.fibo(num);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

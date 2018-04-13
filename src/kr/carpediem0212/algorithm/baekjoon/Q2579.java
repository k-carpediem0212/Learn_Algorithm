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
 * 	계단을 오르는 경우는 '이전 계단을 밟은 경우'와 '이전 계단을 밟지 않는 경우'로 나뉨.
 * 		1. 이전 계단을 밟은 경우 = N + climb(N-1)
 *  	2. 이전 계단을 밟지 않는 경우 = N + climb(N-2)
 *  단, 이전 계단을 밟은 경우 그 이전 계단을 밟을 수 없으므로(규칙 2)
 *			1. N + climb(N-1) => N + (N-1) + climb(N-3)이 됨.
 *
 *	최종적으로 도출된 점화식은
 *		1. N + (N-1) + climb(N-3)
 *      2. N + climb(N-2)
 *  
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : 
 *  ---------------------------
 *  
 */
public class Q2579 {
	private int[] valueOfStairs;
	private int[] cache;

	public Q2579(int[] valueOfStairs) {
		this.valueOfStairs = valueOfStairs;
		this.cache = new int[valueOfStairs.length];

		// 초기화 : 점화식이 - 3을 하기 때문에 2까지는 초기화가 되어야 OutOfIndex 오류가 발생하지 않음.
		cache[1] = valueOfStairs[1];
		cache[2] = Integer.max(valueOfStairs[2], valueOfStairs[2] + valueOfStairs[1]);
	}

	public int climb(int current) {
		// BASE-CASE
		if (current == 0) {
			return cache[0];
		} else if (current == 1) {
			return cache[1];
		} else if (current == 2) {
			return cache[2];
		}

		// Memorization
		if(cache[current] != 0) {
			return cache[current];
		}
		
		int ret = valueOfStairs[current];
		// 점화식 1, 2 중 큰 값을 Return
		ret += Integer.max(valueOfStairs[current - 1] + climb(current - 3), climb(current - 2));

		cache[current] = ret;
		return ret;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfStairs = Integer.parseInt(br.readLine().trim());
			// 시작 계단 포함을 위해 계단 + 1
			int[] valueOfStairs = new int[numOfStairs + 1];

			for (int i = 1; i <= numOfStairs; i++) {
				valueOfStairs[i] = Integer.parseInt(br.readLine().trim());
			}

			Q2579 m = new Q2579(valueOfStairs);
			System.out.println(m.climb(numOfStairs));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *
 *	------------------------------------------------
 *	조건 :
 *	------------------------------------------------
 *	
 *	num을 표현하는데 사용되는 수는 우선
 *	num의 제곱근 보다 작은 정수이다.
 *	
 *	해결 방법은 1부터 num의 제곱근 보다 큰 정수 까지
 *	경우의 수를 확인하여 최소가 되는 값을 Return 하면 된다.
 *	
 *	동전 문제와 동일하게 풀이가 가능하다.		
 *
 *	[점화식]
 *		cache[j] = Math.min(cache[j], cache[j - pow] + 1);
 *    
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q1699 {
	public Q1699() {
		
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

			Q1699 m = new Q1699();
			System.out.println(m.presentSqrt(num));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

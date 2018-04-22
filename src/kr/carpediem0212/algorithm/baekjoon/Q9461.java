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
 *	------------------------------------------------
 *	
 *	i번째 삼각형의 변의 길이는 (i-2)번째 삼각형 길이 + (i-3)번째 삼각형 길이와 같다.	
 *
 *	
 *	[점화식]
 *		cache[i] = cache[i - 2] + cache[i - 3];
 *
 *	검색하여 다른 알고리즘과 비교 시, 그림을 토대로 아래와 같은 점화식도 존재하였다.
 *	(나는 값을 토대로 점화식 도출)
 *	아래와 같은 점화식일 경우 초기화를 좀더 많이 해줘야된다.
 *		cache[i] = cache[i - 1] + cache[i - 5];
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q9461 {
	private int n;
	
	public Q9461(int n) {
		this.n = n;
	}
	
	public long getP() {
		if(n == 1 || n == 2 || n== 3) {
			return 1;
		}
		
		long[] cache = new long[n];
		// 0 ~ 2번째 삼각형 까지는 1 이므로 1로 초기화 
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
				
				Q9461 _m = new Q9461(n);
				System.out.println(_m.getP());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 
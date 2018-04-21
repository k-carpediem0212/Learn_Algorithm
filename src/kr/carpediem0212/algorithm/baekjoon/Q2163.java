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
 *	먼저, 초콜릿은 가로로 먼저 자르나 세로로 먼저 자르나 결과가 동일하다.
 *	이점을 이용해 가로를 먼저 자르거나 세로를 항상 먼저 자르는 형태로 고정이 가능하다.
 *
 *	n*m 초콜릿을 자르는 경우는
 *	n*(m-1) 초콜릿에 n*1 초콜릿을 더한 경우와 같다.
 *		
 *	좀 더 이 문제를 보면 수학적으로 푸는 것도 가능하다.
 *	수학적으로 풀 경우, 상수 시간이기 때문에 훨씬 알고리즘의 성능이 좋다.
 *
 *	아래에 divide는 수학적으로 divide1은 DP로 해결하였다.	
 *	
 *  ---------------------------
 *  공간복잡도 : O(1) - 수학 , O(n^2) - DP
 *  시간복잡도 : O(1) - 수학 , O(n^2) - DP
 *  ---------------------------
 */
public class Q2163 {
	private int n;
	private int m;

	public Q2163(int n, int m) {
		this.n = n;
		this.m = m;
	}
	
	// 수학적으로 풀기
	public int divide() {
		return (n - 1) + (n * (m - 1));
	}
	
	// DP를 이용하여 풀기
	public int divide1() {
		if(n == 1 && m == 1) {
			return 0;
		}
		
		int[][] cache = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {
					cache[i][j] = 0;
				} else if(j == 0) {
					cache[i][j] = cache[i - 1][j] + 1; 
				} else {
					cache[i][j] = cache[i][j - 1] + (i + 1); 
				}
			}
		}
		
		return cache[n - 1][m - 1];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int N = Integer.parseInt(inputDatas[0]);
			int M = Integer.parseInt(inputDatas[1]);

			Q2163 m = new Q2163(N, M);
			System.out.println(m.divide());
			//System.out.println(m.divide1());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

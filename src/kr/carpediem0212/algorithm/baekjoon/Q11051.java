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
 *	이항계수문제
 *	[점화식]
 *		nCr = n-1Cr-1 + nCr-1	
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q11051 {
	public static int n;
	public static int k;
	public static int[][] matrix;
	public static final int MOD = 10007;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			matrix = new int[n + 1][k + 1];

			matrix[0][0] = 1;
			k = (k > (n - k)) ? n - k : k;

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					if (j == 0) {
						matrix[i][j] = 1;
					} else {
						matrix[i][j] = (matrix[i - 1][j] + matrix[i - 1][j - 1]) % MOD;
					}
				}
			}

			System.out.println(matrix[n][k]);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

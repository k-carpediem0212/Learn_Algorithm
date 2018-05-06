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
 *		조건 1. 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다.
 *	------------------------------------------------
 *
 *	i줄 우리에 사자를 배치하는 경우의 수는
 *		1) 배치하지 않는다.
 *		2) 1번 우리에 배치한다.
 *		3) 2번 우리에 배치한다.	
 *	여기서,
 *		2) 1번 우리에 배치한다는 => i-1번째 배치되지 않는 경우 + i-1번째 2번 우리에 사자가 있는경우
 *		3) 2번 우리에 배치한다는 => i-1번째 배치되지 않는 경우 + i-1번째 1번 우리에 사자가 있는경우
 *	로 표현이 가능하다.
 *
 *	도출된 점화식은 아래와 같다.
 *		matrix[0][i] = matrix[0][i - 1] + matrix[1][i - 1] + matrix[2][i - 1];
 *		matrix[1][i] = matrix[0][i - 1] + matrix[2][i - 1];
 *		matrix[2][i] = matrix[0][i - 1] + matrix[1][i - 1];
 *
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q1309 {
	public static int n;
	public static final int MOD = 9901;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[3][n];

			for (int i = 0; i < 3; i++) {
				matrix[i][0] = 1;
			}

			for (int i = 1; i < n; i++) {
				matrix[0][i] = (matrix[0][i - 1] + matrix[1][i - 1] + matrix[2][i - 1]) % MOD;
				matrix[1][i] = (matrix[0][i - 1] + matrix[2][i - 1]) % MOD;
				matrix[2][i] = (matrix[0][i - 1] + matrix[1][i - 1]) % MOD;
			}

			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += (matrix[i][n - 1] % MOD);
			}
			
			System.out.println(sum % MOD);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

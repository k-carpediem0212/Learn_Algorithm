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
 *	입력받은 정사각형 배열을 D라고 할때 D[i][j]를 정사각형의 우측하단이라고 가정한다.
 *	여기서, 정사각형 한변의 길이는 D[i-1][j-1], D[i][j-1], D[i-1][j] 중 가장 작은 값 + 1이다.
 *	(단, D[i][j] == 0 일 경우는 제외한다.)
 *
 *  점화식은 아래와 같다.
 *	
 *	D[i][j] = min(D[i - 1][j - 1], D[i - 1][j], D[i][j - 1]) + 1;
 *
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q1915 {
	public static int n;
	public static int m;
	public static char[][] matrix;
	public static int[][] cache;

	public static int getMaxSquareSize() {
		int max = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (matrix[i][j] == '1') {
					cache[i][j] = min(cache[i - 1][j - 1], cache[i - 1][j], cache[i][j - 1]) + 1;
				}

				max = Integer.max(max, cache[i][j]);
			}
		}

		return max * max;
	}

	public static int min(int num1, int num2, int num3) {
		int temp = (num1 < num2) ? num1 : num2;

		return (temp < num3) ? temp : num3;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			matrix = new char[n + 1][m + 1];
			cache = new int[n + 1][m + 1];

			for (int i = 1; i <= n; i++) {
				String row = br.readLine();
				for (int j = 1; j <= m; j++) {
					matrix[i][j] = row.charAt(j - 1);
				}
			}

			System.out.println(getMaxSquareSize());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

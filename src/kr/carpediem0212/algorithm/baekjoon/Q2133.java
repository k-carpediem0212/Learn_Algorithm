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
 *	이 문제는 우선 경우의 수를 구해보면, n이 홀수 일 경우는 불가함을 알 수 있다.
 *	우선 길이 2의 타일을 만드는 경우는 3가지가 있으므로,
 *	n+2는 n*3으로 표현이가능하다.
 *
 *	추가로 특이한 형태의 타일이 있는데
 *	  ㅡㅡ
 *	|ㅡㅡ|	이런 식으로 맨 위나 아래가 ㅡ로만 채워지는 경우( 가운데가 공유하는 경우)이다.
 *	이런 경우는 n = 4일때 부터 2가지씩(위,아래가 각ㅡ) 존재하므로 n-4 * 2, n-6, n-8 ... 인 경우가 전부 고려되어야 한다.
 *
 *  위 방법을 토대로 점화식은 아래와 같다.
 *  
 *	cache[i] = cache[i - 2] * 3;
 *	(단, n >= 4 cache[i] += cache[i - j] * 2)
 *	(여기서 n은 2씩 증가)
 *
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q2133 {
	public Q2133() {

	}

	public int tiling(int n) {
		if ((n % 2) != 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		}

		int[] cache = new int[n + 1];
		cache[0] = 1;
		cache[2] = 3;

		for (int i = 4; i <= n; i = i + 2) {
			cache[i] = cache[i - 2] * 3;

			for (int j = 4; j <= i; j = j + 2) {
				cache[i] += cache[i - j] * 2;
			}
		}

		return cache[n];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Q2133 m = new Q2133();
			System.out.println(m.tiling(n));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

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
 *		각라운드 마다 열려 있는 문은 닫고, 닫혀있는 문은 연다. 
 *	------------------------------------------------
 *	
 *	문제 해설을 보면 각 라운드별 배수의 방의 상태가 변경됨을 알 수 있다.
 *  각 라운드 별 배수의 방의 상태를 변경하는 이중 for문을 이용하면 된다.
 *  
 *  
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q6359 {
	public static int T;
	public static int n;
	public static final int MOD = 9901;
	public static boolean[] cache;

	public static int game(int n) {
		cache = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j = j + i ) {
				cache[j] = !cache[j];
			}
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (cache[i]) {
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());

			while ((T--) > 0) {
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());

				System.out.println(Q6359.game(n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

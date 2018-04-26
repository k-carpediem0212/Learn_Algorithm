package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *
 *	------------------------------------------------
 *	조건 :
 *		1. 각각의 동전은 몇개라도 사용할 수 있다.
 *		2. 불가능한 경우에는 -1을 출력한다.
 *	------------------------------------------------
 *	
 *	동전 문제의 경우, 낮은 가치의 동전 부터 값 k를 만들 수 있는 수를 구하고
 *	큰 가치의 동전으로 표현이 가능할 경우 대체한다.
 *	(큰 가치의 동전은 작은 가치의 동전보다 갯수가 적게 소모)
 *
 *	이차원 배열로 표현이 가능하지만, 이 문제에서도 이전 값이 나중에 쓰이지 않기 때문에
 *	1차원 배열로 가능하다.
 *
 *	[점화식]
 *		cache[j] = Integer.min(cache[j], cache[j - coins[i]] + 1);
 *	
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q2294 {
	private int n;
	private int k;
	private int[] coins;
	private int[] cache;

	public Q2294(int n, int k, int[] coins) {
		this.n = n;
		this.k = k;
		this.coins = coins;
		this.cache = new int[k + 1];
		
		Arrays.sort(coins);
		//k가 최대 10000이고 최소 동전 가치는 1이므로 많아야 10000개 범위 내에
		//동전으로 표현이 가능하다.
		//넉넉히 잡기 위해 100001로 초기화 해준다.
		Arrays.fill(cache, 100001);
		// 0은 0으로 초기화 한다.
		cache[0] = 0;
		
	}

	public int exchange() {
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				cache[j] = Integer.min(cache[j], cache[j - coins[i]] + 1);
			}
		}
		
		// 초기 값과 cache의 값이 동일한 경우 표현이 불가능 경우
		// 조건에 따라 -1 Return
		if(cache[k] == 100001) {
			return -1;
		}
		
		return cache[k];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(inputDatas[0]);
			int k = Integer.parseInt(inputDatas[1]);
			int[] coins = new int[n];
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(br.readLine().trim());
			}
			
			Q2294 m = new Q2294(n, k, coins);
			System.out.println(m.exchange());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

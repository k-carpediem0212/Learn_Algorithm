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
 *		1. 이친수는 0으로 시작하지 않는다.
 *		2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 *	------------------------------------------------
 *	
 *	가격 V를 표현하는 경우는
 *		i가치 동전 Ci를 사용하여 표현하는 경우와
 *				       사용하지 않고 표현하는 경우 2가지로 나뉜다.
 * 	이 경우,
 * 
 *  점화식은
 *  [점화식]
 * 		DP[i] = DP[i - 1] + DP[i - Vi]
 *	이다.
 *	
 *	DP[i-1]은 현재 동전을 사용하지 않고 지금까지의 동전으로 V를 구하는 경우의 수 이며,
 *	DP[i-Vi]는 V를 현재 동전을 이용하여 나타내는 경우의 수를 말한다.
 *	
 *	여기서, 2차원 배열로 할 시 배열크기 오류가 나므로 1차원 배열로 하였다.
 *	1차원 배열이 가능한 이유는 이전 row를 한번 참조 한 이후 다시 참조할 일이 없기 때문이다.
 *
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q2293 {
	private int numOfCoins;
	private int[] coins;

	public Q2293(int numOfCoins, int[] coins) {
		this.numOfCoins = numOfCoins;
		this.coins = coins;
	}

	public int calculate(int targetValue) {
		// int[][] cache = new int[numOfCoins + 1][targetValue + 1];
		int cache[] = new int[targetValue + 1];

		cache[0] = 1;

		/*
		 * 메모리 초과 코드
		 * 
		 * for(int i = 0; i <= numOfCoins; i++) { cache[i][0] = 1; }
		 * 
		 * for(int i = 1; i <= numOfCoins; i++) { for(int j = 1; j <= targetValue; j++)
		 * { if(j < coins[i - 1]) { cache[i][j] = cache[i - 1][j]; } else { cache[i][j]
		 * = cache[i - 1][j] + cache[i][j - coins[i - 1]]; } } }
		 */

		for (int i = 1; i <= numOfCoins; i++) {
			for (int j = coins[i - 1]; j <= targetValue; j++) {
				cache[j] = cache[j] + cache[j - coins[i - 1]];
			}
		}

		return cache[targetValue];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int numOfCoins = Integer.parseInt(inputDatas[0]);
			int targetValue = Integer.parseInt(inputDatas[1]);
			int[] coins = new int[numOfCoins];

			for (int i = 0; i < numOfCoins; i++) {
				coins[i] = Integer.parseInt(br.readLine().trim());
			}

			Q2293 m = new Q2293(numOfCoins, coins);
			System.out.println(m.calculate(targetValue));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

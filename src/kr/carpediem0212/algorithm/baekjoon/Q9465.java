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
 *		1. 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.
 *	------------------------------------------------
 *	
 *	i번째 처음 스티커를 떼는 경우의 수는 아래와 같다.		
 *		1. (i-1)번째 두번째 스티커를 떼는 경우
 *		2. (i-1)번째 스티커를 떼지 않는 경우
 *
 *	위를 바탕으로 점화식을 도출 하면 아래와 같다.
 *		cache[0][i] = stickers[0][i - 1] + Integer.max(cache[1][i - 1], Integer.max(cache[0][i - 2], cache[1][i - 2]));
 *    	cache[1][i] = stickers[1][i - 1] + Integer.max(cache[0][i - 1], Integer.max(cache[0][i - 2], cache[1][i - 2]));
 *    
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q9465 {
	private int[][] stickers;
	private int n;
	private int[][] cache;

	public Q9465(int n, int[][] stickers) {
		this.n = n;
		this.stickers = stickers;
		this.cache = new int[2][n + 1];
	}

	public int maxValue() {
		cache[0][1] = stickers[0][0];
		cache[1][1] = stickers[1][0];
		
		for(int i = 2; i <= n; i++) {
			cache[0][i] = stickers[0][i - 1] + Integer.max(cache[1][i - 1], Integer.max(cache[0][i - 2], cache[1][i - 2]));
			cache[1][i] = stickers[1][i - 1] + Integer.max(cache[0][i - 1], Integer.max(cache[0][i - 2], cache[1][i - 2]));
			
		}
		
		return Integer.max(cache[0][n], cache[1][n]);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			while ((numOfTestCase--) > 0) {
				int n = Integer.parseInt(br.readLine().trim());
				int[][] stickers = new int[2][n];

				for (int i = 0; i < 2; i++) {
					String[] inputDatas = br.readLine().trim().split("\\s+");
					
					for (int j = 0; j < n; j++) {
						stickers[i][j] = Integer.parseInt(inputDatas[j]);
					}
				}

				Q9465 m = new Q9465(n, stickers);
				System.out.println(m.maxValue());
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

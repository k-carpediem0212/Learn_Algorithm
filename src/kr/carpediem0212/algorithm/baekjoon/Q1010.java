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
 *		1. 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.
 *		2. 다리끼리는 서로 겹쳐질 수 없다
 *	------------------------------------------------
 *	
 *	문제를 잘 생각해보면,
 *	다리를 놓는 위치 보다는 어디를 빈 곳으로 둘지를 결정하고
 *	나머지에 다리를 순서대로 연결하면 쉽게 해결 할 수 있다.
 *
 *	빈공간을 놓는 경우의 수 = nCr (n은 동쪽 도시의 수, r은 서쪽 도시의 수)
 *	
 *	[점화식]
 *	
 *	DP[n][r] = DP[n-1][r-1] + DP[n - 1][r]  - (nCr = n-1Cr-1 + n-1Cr)
 *	단, n == r 이거나 r == 0 일 경우는 1
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q1010 {
	private int west;
	private int east;
	private int cache[][];
	
	public Q1010(int west, int east) {
		this.west = west;
		this.east = east;
		// 편의를 위해 배열 크기를 row, column에 각각 + 1하여 생성
		this.cache = new int[east + 1][east + 1];
	}
	
	public int bridge() {
		// east == west 일 경우, 1
		if(east == west) {
			return 1;
		} else if (west == 1) { // 좀 더 빠르게 값을 얻기 위한 분기
			return east;
		}
		
		cache[1][0] = 1;
		cache[1][1] = 1;
		
		// nCr = nCn-r 과 동일 하다는 것을 이용 작은 값을 구하기 위해
		west = Integer.min(west, (east - west));
		
		for(int i = 2; i <= east; i++) {
			for(int j = 0; j <= west; j++) {
				if(j == 0 || i == j) {
					cache[i][j] = 1;
				} else {
					cache[i][j] = cache[i - 1][j] + cache[i - 1][j - 1];
				}
			}
		}
		
		return cache[east][west];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());
			
			while((numOfTestCase--) > 0) {
				String[] inputDatas = br.readLine().trim().split("\\s+");
				int west = Integer.parseInt(inputDatas[0]);
				int east = Integer.parseInt(inputDatas[1]);
				
				Q1010 m = new Q1010(west, east);
				System.out.println(m.bridge());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

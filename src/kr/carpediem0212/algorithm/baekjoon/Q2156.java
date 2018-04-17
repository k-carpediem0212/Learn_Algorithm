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
 *		1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 *		2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 *	------------------------------------------------
 *	
 *	i번째 잔 기준으로, 가능한 경우를 생각해보면
 *		CASE 1. i번째 잔을 마시지 않는 경우
 *		CASE 2. i번째 잔을 마시고, (i-1)번째 잔을 마시지 않는 경우
 *		CASE 3. i번째 잔을 마시고, (i-1)번째 잔도 마시는 경우
 *	로 나뉜다.
 *	
 *	각 CASE에 대한 점화식은 아래와 같다.
 *	[점화식] 
 *		1. cache[i - 1]
 *		2. wines[i] + cache[i - 2]
 *		3. wines[i] + wines[i-1] + cache[i-3]
 *	1.은 현재 잔을 마시지 않았을 경우, 이전까지의 최대 합이 현재까지의 최대 합이 된다.
 *	2.(i-2)번째까지의 최대 합과 i번째 와인의 합이 된다. (i-1은 마시지 않으므로)
 *	3.(i-3)번째까지의 합과 와인 i, i-1의 양의 합이 된다. (i, i-1을 마실 경우 i-2는 마실수가 없다.) 
 *	
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q2156 {
	private int[] wines;
	private int[] cache;
	private int numOfWine;
	
	public Q2156(int[] wines, int numOfWine) {
		this.wines = wines;
		this.cache = new int[wines.length];
		this.numOfWine = numOfWine;
	}
	
	public int drink() {
		if(numOfWine == 1) {
			return wines[1];
		} else if (numOfWine == 2) {
			return wines[2] + wines[1];
		}
		
		cache[1] = wines[1];
		cache[2] = wines[2] + wines[1];
		
		for(int i = 3; i <= numOfWine; i++) {
			// 1. i를 안마실 경우
			int max = cache[i - 1];
			// 2. i를 마시고 (i-1)을 마시지 않을 경우
			max = Integer.max(max, (wines[i] + cache[i - 2]));
			// 3. i를 마시고 (i-1)을 마실 경우
			max = Integer.max(max, (wines[i] + wines[i-1] + cache[i - 3]));
			
			cache[i] = max;
		}
		
		return cache[numOfWine];
	}

	/*
	 * 맨처음 작성하였던 코드
	 * 위는 다른 사람 코드를 보며 리팩토링
	 * 아래는 이차원 배열을 이용한  코드
	 * 
	 */
	/*
	public void drink() {
		if(numOfWine == 1) {
			//return wines[0];
			System.out.println(wines[0]);
		} else if (numOfWine == 2) {
			//return wines[0] + wines[1];
			System.out.println(wines[1]);
		}
		
		cache[0][0] = wines[0];
		cache[1][0] = wines[0];
		cache[0][1] = wines[0] + wines[1];
		cache[1][1] = wines[1];
		
		int max = 0;
		for(int i = 2; i < numOfWine; i++) {
			cache[0][i] = wines[i] + cache[1][i - 1];
			cache[1][i] = wines[i] + Integer.max(cache[0][i - 2], cache[1][i - 2]);
			
			int cur = Integer.max(cache[0][i], cache[1][i]);
			if (max < cur) {
				max = cur;
			}
		}
		
		System.out.println(max);
	}*/

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfWine = Integer.parseInt(br.readLine().trim());
			//편의를 위해 + 1하여 배열 생성
			int[] wines = new int[numOfWine + 1];
			
			for(int i = 1; i <= numOfWine; i++) {
				wines[i] = Integer.parseInt(br.readLine().trim());
			}
			
			Q2156 m = new Q2156(wines, numOfWine);
			System.out.println(m.drink());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

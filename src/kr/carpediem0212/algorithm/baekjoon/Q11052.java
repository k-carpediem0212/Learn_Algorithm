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
 *	------------------------------------------------
 *	
 *	거스름돈 접근 방법과 동일하게 접근하였다.
 *  row를 set로
 *  column을 파는 붕어빵의 수로 하였으며,
 *  
 *  점화식은 아래와 같다.
 *  
 *  if (j >= i) {
 *		cache[i][j] = Integer.max(cache[i - 1][j], (cache[i][j - i] + valueOfSet[i - 1]));
 *	} else {
 *		cache[i][j] = cache[i - 1][j]; 
 *	}
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q11052 {
	private int[] valueOfSet;
	private int[][] cache;
	private int numOfBread;

	public Q11052(int numOfBread, int[] valueOfSet) {
		this.numOfBread = numOfBread;
		this.valueOfSet = valueOfSet;
		// 편의를 위해 row, column 크기를 +1 하여 캐쉬를 생성
		this.cache = new int[valueOfSet.length + 1][valueOfSet.length + 1];
	}

	public int sell() {
		for (int i = 1; i <= numOfBread; i++) {
			for (int j = 1; j <= numOfBread; j++) {
				if (j >= i) {
					cache[i][j] = Integer.max(cache[i - 1][j], (cache[i][j - i] + valueOfSet[i - 1]));
				} else {
					cache[i][j] = cache[i - 1][j]; 
				}
			}
		}
		
		return cache[numOfBread][numOfBread];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfBread = Integer.parseInt(br.readLine().trim());
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int[] valueOfSet = new int[inputDatas.length];

			for (int i = 0; i < inputDatas.length; i++) {
				valueOfSet[i] = Integer.parseInt(inputDatas[i]);
			}

			Q11052 m = new Q11052(numOfBread, valueOfSet);
			System.out.println(m.sell());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

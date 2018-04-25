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
 *	i번째 수가 오는 경우의 수는 
 *
 *  row를 set로
 *  column을 파는 붕어빵의 수로 하였으며,
 *  
 *  낮은 세트부터 cache를 채워가며 최종 값을 찾도록 하였다.
 *  점화식은 아래와 같다.
 *  
 *  if (j >= i) {
 *		cache[i][j] = Integer.max(cache[i - 1][j], (cache[i][j - i] + valueOfSet[i - 1]));
 *	} else {
 *		cache[i][j] = cache[i - 1][j]; 
 *	}
 *
 *  10 + 9 + 8 + 7 + 5 + 4 + 3 + 2 + 1
 *  0  1  2  3  4  5  6  7  8  9
 *  1  1  1  1  1  1  1  1  1  1
 *  1  2  3  4  5  6  7  8  9  10
 *  1  3  6  10 15 21 28 36 45 55
 *  1  4  10 20 35 46 74 110 155 210
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 * 
 */
public class Q11057 {
	private final int MOD = 10007;
	private int[] cache;
	private int num;
	
	public Q11057(int num) {
		this.num = num;
		this.cache = new int[10];
	}
	
	public int increase() {
		Arrays.fill(cache, 1);
		
		for (int i = 2; i <= num; i++) {
			for( int j = 1; j <= 9; j++) {
				cache[j] = (cache[j - 1] + cache[j]) % MOD;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += cache[i] % MOD;
		}
		
		//System.out.println(Arrays.toString(cache));
		return sum % MOD;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int num = Integer.parseInt(br.readLine().trim());
			
			Q11057 m = new Q11057(num);
			System.out.println(m.increase());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

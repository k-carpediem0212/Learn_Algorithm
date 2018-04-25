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
 *		1. 인접한 수가 같아도 오름차순으로 친다.
 *	------------------------------------------------
 *	
 *	i번째에 올 수 있는 수는 (i-1)번째 수에 영향을 받는다.
 *	i번째에는 (i-1)번째의 수와 같거나 큰수만 가능하기 때문에
 *	아래와 같이 이차원 배열을 이용하면 [i][j] = [i -1][j] + [i][j - 1]로 구할 수 있다.
 *
 *  0  1  2  3  4  5  6  7  8  9
 *  ------------------------------
 *  1  1  1  1  1  1  1  1  1  1
 *  1  2  3  4  5  6  7  8  9  10
 *  1  3  6  10 15 21 28 36 45 55
 *  1  4  10 20 35 46 74 110 155 210
 *	------------------------------
 *
 *	이전 값들을 계속 보존해야할 필요가 없으므로 1차원 배열을 이용하였다.
 *	
 *	[점화식]
 * 		[i][j] = [i -1][j] + [i][j - 1]
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
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

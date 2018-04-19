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
 *		2×n 크기의 직사각형을 1×2, 2×1, 2x2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *		직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *	------------------------------------------------
 *	
 *	tiling의 타일링하는 CASE는 
 *		CASE 1. 1x2 타일을 놓는 경우
 *		CASE 2. 2x1 타일을 놓는 경우
 *		CASE 3. 2x2 타일을 놓는 경우
 *  3가지로 나눌 수 있음.
 *  
 * 	여기서 CASE 1과 3은 같이 때문에 *2하면 된다.
 *  
 *	전체 길이가 width일 때,
 *		CASE 1은 타일링 이후 width = width - 2
 *		CASE 2는 타일링 이후 width = width - 1
 *	가 됨. (피보나치와 동일)
 *
 *	여기서 도출된 점화식은 두 경우의 합이므로 (tiling - 타일링 하는 함수로 가정) 
 *		tiling(width) = (2*tiling(width-2)) + tiling(width-1)
 *	이 된다.
 *    
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q11727 {
	private final int MOD = 10007;
	private int width;
	private int[] cache;

	public Q11727(int width) {
		this.width = width;
		this.cache = new int[width + 1];
	}

	public int tiling() {
		if (width == 1) {
			return 1;
		} else if (width == 2) {
			return 3;
		}

		cache[1] = 1;
		cache[2] = 3;

		for (int i = 3; i <= width; i++) {
			cache[i] = (cache[i - 1] + (2 * cache[i - 2])) % MOD;
		}

		return cache[width] % MOD;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int width = Integer.parseInt(br.readLine().trim());

			Q11727 m = new Q11727(width);
			System.out.println(m.tiling());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

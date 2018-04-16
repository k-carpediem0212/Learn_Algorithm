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
 *		2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *		직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *		
 *	------------------------------------------------
 *	
 *	tiling의 타일링하는 CASE는 
 *		CASE 1. 1x2 타일을 놓는 경우
 *		CASE 2. 2x1 타일을 놓는 경우
 *  2가지로 나눌 수 있음.
 *  
 *	전체 길이가 width일 때,
 *		CASE 1은 타일링 이후 width = width - 2
 *		CASE 2는 타일링 이후 width = width - 1
 *	가 됨. (피보나치와 동일)
 *
 *	여기서 도출된 점화식은 두 경우의 합이므로 (tiling - 타일링 하는 함수로 가정) 
 *		tiling(width) = tiling(width-2) + tiling(width-1)
 *	이 된다.
 *    
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q11726 {
	
	public Q11726() {
	}
	
	public int tiling(int width) {
		if(width == 1) {
			return 1;
		} else if(width == 2) {
			return 2;
		}
		
		// width가 1, 2일 경우는 초기화
		int[] cache = new int[width];
		cache[0] = 1;
		cache[1] = 2;
		
		for(int i = 2; i < width; i++) {
			// 10007로 나누라는 조건 적용
			cache[i] = (cache[i - 1] + cache[i - 2]) % 10007;
		}
		
		return cache[width - 1];
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int width = Integer.parseInt(br.readLine().trim());
			
			Q11726 m = new Q11726();
			System.out.println(m.tiling(width));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

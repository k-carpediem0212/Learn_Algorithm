package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  X의 전체 조합의 수는 X의 부분들 X'의 전체 조합의 수의 합과 같다.
 *  ex) 5의 전체 가능한 조합의 수는 = 
 *  	(5-1) 한 4의 전체 조합의 수  + (5-2) 한 3의 전체 조합의 수 + (5-3) 한 2의 전체 조합의 수
 *  
 *  공간복잡도 : O(n)
 *  시간복잡도 : 
 */
public class Q9095 {
	private int cache[];
	
	public Q9095(int num) {
		// 인덱스와 값을 맞춤으로써의 편의를 위해 +1 크기의 배열 생성
		this.cache = new int[num + 1];
		
		System.out.println(comb(num));
	}
	
	public int comb(int num) {
		//BASE-CASE
		if(num == 0) {
			cache[0] = 1;
			return cache[0];
		}
		
		//Memorization
		if(cache[num] != 0) {
			return cache[num];
		}
		
		int ret = 0;

		for(int i = 1; i <= 3; i++) {
			int nextNum = num - i;
			// -1, -2, -3의 결과가 0이하면 조합 불가.
			// 0보다 크거나 같을 경우 순회하여, 모든 조합의 결과를 더함.
			if(nextNum >= 0) {
				ret += comb(nextNum);
			}
		}
		cache[num] = ret;
		
		return ret;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());
			
			while((numOfTestCase--) > 0) {
				int num = Integer.parseInt(br.readLine().trim());
				
				Q9095 m = new Q9095(num);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  X의 최소 연산의 수는 X의 부분 연산의 결과인 X'의 최소 연산의 수  + 1과 같다.
 *  	ex) 10의 최소 연산의 수는  MIN(5의 최소 연산의 수, 9의 최소 연산의 수)
 *   
 *  공간복잡도 : O(n)
 *  시간복잡도 : 
 */
public class Q1463 {
	private int cache[];
	
	public Q1463(int num) {
		// 인덱스와 값을 맞춤으로써의 편의를 위해 +1 크기의 배열 생성
		this.cache = new int[num + 1];
		
		System.out.println(operate(num));
	}
	
	public int operate(int num) {
		// BASE-CASE 1
		if(num == 1) {
			return cache[0];
		} else if(num == 2) {
			cache[2] = 1;
			return 1;
		} else if(num == 3) {
			cache[3] = 1;
			return 1;
		}
		
		
		//Memorization
		if(cache[num] != 0) {
			return cache[num];
		}
		
		int ret = Integer.MAX_VALUE;
		// 연산 1. num / 3 
		if((num % 3) == 0) {
			ret = Integer.min(ret, operate(num / 3));
		}
		
		// 연산 1. num / 2
		if((num % 2) == 0) {
			ret = Integer.min(ret, operate(num / 2));
		}
		
		// 연산 1. num - 1
		ret = Integer.min(ret, operate(num - 1));
		
		// num의 경우의 수 = 부분 + 1 ( 연산 1,2,3 중 하나이기 때문)
		// => ret를 1 증가.
		ret++;
		cache[num] = ret;
		
		return ret;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int num = Integer.parseInt(br.readLine().trim());

			Q1463 m = new Q1463(num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

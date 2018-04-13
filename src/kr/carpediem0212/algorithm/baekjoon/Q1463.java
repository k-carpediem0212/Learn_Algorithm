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
 *		연산 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *		연산 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 *		연산 3. 1을 뺀다.
 *	------------------------------------------------
 *
 *	주어진 정수를 1로 만드는 최소 연산의 수 X는
 *	주어진 정수에 연산 1,2,3을 하여 얻는 수의 최소 연산의 수 X' + 1과 같다.
 *	
 *	도출된 점화식 : X = X' + 1 (여기서 X'는 X를 통해 얻을 수 있는 부분의 최소)
 *  
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : 
 *  ---------------------------
 */
public class Q1463 {
	private int cache[];
	
	public Q1463(int num) {
		// 편의를 위해 배열 크기를 + 1로 생성.
		this.cache = new int[num + 1];

		System.out.println(operate(num));
	}
	
	public int operate(int num) {
		// BASE-CASE 1
		// 1은 연산이 필요 하지 않으므로 0, 2와 3은 1번의 연산으로 가능하기 때문에 1을 Return
		if (num == 1) {
			return 0;
		} else if(num == 2 || num == 3) {
			return 1;
		}
		
		//Memorization
		if(cache[num] != 0) {
			return cache[num];
		}
		
		// 연산 3
		int ret = operate(num - 1);
		
		// 연산 1이 가능할 경우 
		if((num % 3) == 0) {
			ret = Integer.min(ret, operate(num / 3));
		}
		
		// 연산 2가 가능할 경우
		if((num % 2) == 0) {
			ret = Integer.min(ret, operate(num / 2));
		}
		
		// 점화식 
		ret = ret + 1;
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

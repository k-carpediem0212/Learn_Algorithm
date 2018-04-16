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
 *		1. 이친수는 0으로 시작하지 않는다.
 *		2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 *	------------------------------------------------
 *	
 *	N번째 자리에 1이 오는 경우 => (N-1)번째가 0 => (N-2) 번째의 수 만큼
 *	N번째 자리에 0이 오는 경우 => (N-1)의 수 만큼
 *	
 *	도출된 점화식  (m은 method를 의미)
 *		m[N] = m[N-1] + m[N-2]  
 *  	(피보나치와 동일한 결과를 냄을 확인할 수 있다.)
 *	
 *	
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q2193 {
	public Q2193() {
	}
	
	public long getPinaryNumber(int lengthOfNum) {
		if(lengthOfNum == 1) {
			return 1;
		} else if (lengthOfNum == 2) {
			return 1;
		}
		
		// overflow로 인해 long으로 cache 선언
		long[] cache = new long[lengthOfNum];
		cache[0] = 1;
		cache[1] = 1;
		
		for(int i = 2; i < lengthOfNum; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		
		return cache[lengthOfNum - 1];
		/*
		// 아래는 재귀로 구현 코드 (시간 초과로 인해 위와 같이 리팩토링)
		if(lengthOfNum == 1) {
			return 1;
		} else if (lengthOfNum == 2) {
			return 1;
		}
		
		return getPinaryNumber(lengthOfNum - 1) + getPinaryNumber(lengthOfNum - 2);
		*/ 
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int lengthOfNum = Integer.parseInt(br.readLine().trim());
			
			Q2193 m = new Q2193();
			System.out.println(m.getPinaryNumber(lengthOfNum));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

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
 *		수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.(int형으로 가능)
 *	------------------------------------------------
 *	
 *	i가 양수 일 경우 i에 0 보다 큰수를 더하면 항상 i보다 크다는 점을 이용
 *	
 *	[점화식] (fibo는 0,1의 호출 횟수를 구하는 함수)
 *		cache[i] = Integer.max(sequences[i] + cache[i - 1], sequences[i]);
 *	
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q1912 {
	private int[] sequences;
	private int[] cache;
	private int numOfSequences;

	public Q1912(int[] sequences, int numOfSequences) {
		this.sequences = sequences;
		this.numOfSequences = numOfSequences;
		this.cache = new int[numOfSequences];
	}

	public int maxSum() {
		if (numOfSequences == 1) {
			return sequences[0];
		}

		cache[0] = sequences[0];

		int max = cache[0];

		for (int i = 1; i < sequences.length; i++) {
			cache[i] = Integer.max(sequences[i] + cache[i - 1], sequences[i]);

			if (max < cache[i]) {
				max = cache[i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfSequences = Integer.parseInt(br.readLine().trim());

			String[] inputDatas = br.readLine().trim().split("\\s+");
			int[] sequences = new int[numOfSequences];

			for (int i = 0; i < numOfSequences; i++) {
				sequences[i] = Integer.parseInt(inputDatas[i]);
			}

			Q1912 m = new Q1912(sequences, numOfSequences);
			System.out.println(m.maxSum());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {
	public static int sizeOfSequence;
	public static int[] sequence;
	public static int[] cache;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sizeOfSequence = Integer.parseInt(st.nextToken());
			sequence = new int[sizeOfSequence];
			cache = new int[sizeOfSequence];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < sizeOfSequence; i++) {
				sequence[i] = Integer.parseInt(st.nextToken());
			}

			cache[0] = 1;

			int max = 1;
			for (int i = 1; i < sizeOfSequence; i++) {
				int cnt = 0;
				
				for(int j = 0; j < i; j++) {
					if(sequence[i] > sequence[j]) {
						if(cnt < cache[j]) {
							cnt = cache[j];
						}
					}
				}
				
				cache[i] = cnt + 1;

				if(cache[i] > max) {
					max = cache[i];
				}
			}
			
			System.out.println(max);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

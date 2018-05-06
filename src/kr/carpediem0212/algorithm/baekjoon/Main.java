package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int n;
	public static final int MOD = 9901;
	public static boolean[] cache;

	public static int game(int n) {
		cache = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j = j + i ) {
				cache[j] = !cache[j];
			}
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (cache[i]) {
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());

			while ((T--) > 0) {
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());

				System.out.println(Main.game(n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static int r;
	public static int c;
	public static char[][] board;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };
	public static HashSet<Character> isVisit = new HashSet<>();;
	public static int max = 0;

	public static void dfs(int y, int x, int cnt) {
		isVisit.add(board[y][x]);

		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= r || nextX >= c) {
				continue;
			}

			if (!isVisit.contains(board[nextY][nextX])) {
				dfs(nextY, nextX, cnt + 1);
			}
		}
		
		if (cnt > max) {
			max = cnt;
		}
		
		isVisit.remove(board[y][x]);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			board = new char[r][c];

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				board[i] = st.nextToken().toCharArray();
			}

			Main.dfs(0, 0, 1);
			System.out.println(max);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

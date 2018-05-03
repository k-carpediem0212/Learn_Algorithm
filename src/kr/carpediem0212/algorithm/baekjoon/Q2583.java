package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *	------------------------------------------------
 *	조건 :
 *	------------------------------------------------
 *
 *	Queue를 이용한 BFS로 해결
 *  
 *  ---------------------------
 *  공간복잡도 : 
 *  시간복잡도 : 
 *  ---------------------------
 *  
 */
public class Q2583 {
	public static int m;
	public static int n;
	public static int k;
	public static int[][] map;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };

	public static void area() {
		LinkedList<Integer> results = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					results.add(bfs(new Pair(i, j)));
				}
			}
		}

		Collections.sort(results);
		
		System.out.println(results.size());
		for (Integer integer : results) {
			System.out.print(integer + " ");
		}
	}

	public static int bfs(Pair startArea) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(startArea);
		map[startArea.y][startArea.x] = 1;
		int size = 1;
		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];

				if (nextY < 0 || nextX < 0 || nextY >= m || nextX >= n) {
					continue;
				}

				if (map[nextY][nextX] == 0) {
					queue.offer(new Pair(nextY, nextX));
					map[nextY][nextX] = 1;
					size++;
				}
			}
		}

		return size;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[m][n];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int lx = Integer.parseInt(st.nextToken());
				int ly = Integer.parseInt(st.nextToken());
				int rx = Integer.parseInt(st.nextToken());
				int ry = Integer.parseInt(st.nextToken());

				for (int j = ly; j < ry; j++) {
					for (int k = lx; k < rx; k++) {
						map[j][k] = 1;
					}
				}
			}

			Q2583.area();

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

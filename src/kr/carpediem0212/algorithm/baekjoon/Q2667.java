package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *	
 *	------------------------------------------------
 *	조건 :
 *	------------------------------------------------
 *	
 *	BFS로 해결
 *	처음 1인 노드들을 먼저 큐에 삽입하여 초기화 하고
 *	BFS 수행
 *	BFS 수행하면서, 방문한 집은 '0'으로 값을 변경
 *  
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n^3)? 시간 복잡도 계산 어려움.
 *  ---------------------------
 */
public class Q2667 {
	private int size;
	private char[][] map;
	private int[] dy = { 0, 0, 1, -1 };
	private int[] dx = { 1, -1, 0, 0 };
	private Queue<Pair> queue;
	private LinkedList<Integer> results;

	public Q2667(int size, char[][] map) {
		this.size = size;
		this.map = map;
		this.queue = new LinkedList<>();
		results = new LinkedList<>();

		/*
		 * for (int i = 0; i < size; i++) { System.out.println(Arrays.toString(map[i]));
		 * }
		 */
	}

	public void grouping() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == '1') {
					queue.offer(new Pair(i, j));
					map[i][j] = '0';
					results.add(bfs());
				}
			}
		}
		
		System.out.println(results.size());
		Collections.sort(results);
		
		for (int cnt : results) {
			System.out.println(cnt);
		}
	}

	public int bfs() {
		int cnt = 1;

		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				
				if (nextY < 0 || nextX < 0 || nextY >= size || nextX >= size) {
					continue;
				}

				if (map[nextY][nextX] == '1') {
					queue.offer(new Pair(nextY, nextX));
					map[nextY][nextX] = '0';
					cnt++;
				}
			}	
		}
		
		return cnt;
	}

	public class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			char[][] map = new char[size][size];

			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				map[i] = st.nextToken().toCharArray();
			}

			Q2667 m = new Q2667(size, map);
			m.grouping();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

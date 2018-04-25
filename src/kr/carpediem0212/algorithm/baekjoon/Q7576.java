package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *	
 *	!!추후 리팩토링 필요 / 시간이 너무 오래 걸림
 *
 *	------------------------------------------------
 *	조건 :
 *	------------------------------------------------
 *	
 *	BFS로 해결
 *	처음 1인 노드들을 먼저 큐에 삽입하여 초기화 하고
 *	BFS 수행
 *	
 *  
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : 
 *  ---------------------------
 *  
 */
public class Q7576 {
	private int m;
	private int n;
	private int[][] box;
	private int[] coordinateX = { 0, 0, 1, -1 };
	private int[] coordinateY = { 1, -1, 0, 0 };

	public Q7576(int m, int n, int[][] box) {
		this.m = m;
		this.n = n;
		this.box = box;
	}

	public int ripen() {
		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					queue.offer(new Pair(i, j));
				}
			}
		}
		
		int max = 0;
		while (!queue.isEmpty()) {
			Pair current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextY = current.y + coordinateY[i];
				int nextX = current.x + coordinateX[i];

				if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
					continue;
				}

				if (box[nextY][nextX] == 0) {

					queue.offer(new Pair(nextY, nextX));
					box[nextY][nextX] = box[current.y][current.x] + 1;
					if (box[nextY][nextX] > max) {
						max = box[nextY][nextX];
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
			}
		}
		
		if(max == 0) {
			return 0;
		}
		
		return max - 1;
	}

	public class Pair {
		private int y;
		private int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int m = Integer.parseInt(inputDatas[0]);
			int n = Integer.parseInt(inputDatas[1]);
			int[][] box = new int[n][m];

			for (int i = 0; i < n; i++) {
				String[] rowDatas = br.readLine().trim().split("\\s+");
				for (int j = 0; j < m; j++) {
					box[i][j] = Integer.parseInt(rowDatas[j]);
				}
			}

			Q7576 _m = new Q7576(m, n, box);
			System.out.println(_m.ripen());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

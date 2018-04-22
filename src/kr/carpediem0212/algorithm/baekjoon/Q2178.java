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
 *	BFS 해결을 위한 문제
 *	
 *	아직 방문하지 않는 노드가 2번이상 Queue에 삽입되지 않도록 하기 위해
 *	큐에 삽입과 동시에 방문 처리 및 거리계상(위상 계산)	
 *		
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q2178 {
	private int n;
	private int m;
	private char[][] matrix;
	private int[] coordinateX = {0, 0, 1, -1};
	private int[] coordinateY = {1, -1, 0, 0};
	
	public Q2178(int n, int m, char[][] matrix) {
		this.n = n;
		this.m = m;
		this.matrix = matrix;
	}

	public int explore(int x, int y) {
		// 방문 확인 용 배열
		boolean[][] isVisit = new boolean[n][m];
		// 거리 계산 용 배열
		int[][] distance = new int[n][m];
		
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(x,y));
		isVisit[y][x] = true;
		
		distance[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Pair location = queue.poll();
			
			for(int i = 0; i < 4; i ++) {
				int nextY = location.y + coordinateY[i];
				int nextX = location.x + coordinateX[i];
				
				// 배열을 벗어날 경우 Pass
				if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
					continue;
				}
				
				if((matrix[nextY][nextX] == '1') && (!isVisit[nextY][nextX])) {
					queue.offer(new Pair(nextY, nextX));
					// 재방문을 하지 않도록 하기 위해 Queue에 삽입과 동시에 방문처리
					isVisit[nextY][nextX] = true;
					distance[nextY][nextX] = distance[location.y][location.x] + 1;
				}
			}
		}

		return distance[n - 1][m - 1];
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
			int n = Integer.parseInt(inputDatas[0]);
			int m = Integer.parseInt(inputDatas[1]);
			char[][] matrix = new char[n][m];
			
			for(int i = 0; i < n; i++) {
				char[] rowDatas = br.readLine().trim().toCharArray();
				
				matrix[i] = rowDatas;
			}
			
			Q2178 _m = new Q2178(n, m, matrix);
			System.out.println(_m.explore(0, 0));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

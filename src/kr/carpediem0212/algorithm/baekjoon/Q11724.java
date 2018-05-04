package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
 *	bfs를 이용
 *	방문 여부를 저장하는 배열을 통해
 *  전체 노드를 방문할때까지 bfs를 수행하고
 *  bfs 수행 횟수를 리턴
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q11724 {
	public static int numOfVertex;
	public static int numOfEdge;
	public static int[][] matrix;
	public static boolean[] isVisit;

	public static int getcc() {
		int cc = 0;
		for (int i = 0; i < numOfVertex; i++) {
			if (isVisit[i] == false) {
				bfs(i);
				cc++;
			}
		}
		
		return cc;
	}

	public static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(vertex);
		isVisit[vertex] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < numOfVertex; i++) {
				if (matrix[current][i] == 1 && isVisit[i] == false) {
					queue.offer(i);
					isVisit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			numOfVertex = Integer.parseInt(st.nextToken());
			numOfEdge = Integer.parseInt(st.nextToken());
			matrix = new int[numOfVertex][numOfVertex];
			isVisit = new boolean[numOfVertex];

			for (int i = 0; i < numOfEdge; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				matrix[u - 1][v - 1] = matrix[v - 1][u - 1] = 1;
			}
			System.out.println(Q11724.getcc());

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

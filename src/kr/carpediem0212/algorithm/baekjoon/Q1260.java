package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
 *	BFS DFS 문제
 *	BFS는 Queue를 이용하여 구현
 *	DFS는 재귀를 이용하여 구현(스택을 이용하여도 구현 가능)
 *  
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q1260 {
	private int numOfVertex;
	private int[][] matrix;
	private boolean[] isVisit;
	
	public Q1260(int numOfVertex, int[][] matrix) {
		this.numOfVertex = numOfVertex;
		this.matrix = matrix;
		
		isVisit = new boolean[numOfVertex + 1];
	}

	public void bfs(int vertex) {
		Queue<Integer> bfsQueue = new LinkedList<>();
		
		bfsQueue.offer(vertex);
		isVisit[vertex] = true;
		System.out.print(vertex);
		
		while(!bfsQueue.isEmpty()) {
			vertex = bfsQueue.poll();
			
			for(int i = 0; i <= numOfVertex; i++) {
				if((matrix[vertex][i] == 1) && (!isVisit[i])) {
					bfsQueue.offer(i);
					isVisit[i] = true;
					System.out.print(" "+ i);
				}
			}
		}
		
		// 처음 구현한 코드
		// boolean[] isVisit = new boolean[numOfVertex + 1];
		//
		// if (isVisit[numOfVertex]) {
		// return;
		// }
		//
		// isVisit[start] = true;
		// System.out.print(start);
		//
		// for (int i = 0; i <= numOfVertex; i++) {
		// if (matrix[start][i] == 1 && start != i) {
		// bfsQueue.offer(i);
		// }
		// }
		//
		// if (!bfsQueue.isEmpty()) {
		// bfs(bfsQueue.poll());
		// }
	}
	
	public void reset() {
		Arrays.fill(isVisit, false);
	}

	public void dfs(int vertex) {
		isVisit[vertex] = true;
		System.out.print(vertex);

		for(int i = 1; i <= numOfVertex; i++) {
			if((matrix[vertex][i] == 1) && (!isVisit[i])) {
				System.out.print(" ");
				dfs(i);
			}
		}
		
		//처음 구현한 코드
		// if (isVisit[start]) {
		// return;
		// }
		//
		// isVisit[start] = true;
		// System.out.println(start);
		//
		// for (int i = numOfVertex; i > 0; i--) {
		// if (matrix[start][i] == 1 && start != i) {
		// if(!isVisit[i]) {
		// dfsStack.push(i);
		// }
		// }
		// }
		//
		// if (!dfsStack.isEmpty()) {
		// int next = dfsStack.pop();
		// dfs(next);
		// }
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputData = br.readLine().trim().split("\\s+");
			int numOfVertex = Integer.parseInt(inputData[0]);
			int numOfEdge = Integer.parseInt(inputData[1]);
			int startVertex = Integer.parseInt(inputData[2]);

			int[][] matrix = new int[numOfVertex + 1][numOfVertex + 1];
			for (int i = 0; i < numOfEdge; i++) {
				String[] edgeData = br.readLine().trim().split("\\s+");
				int vertex1 = Integer.parseInt(edgeData[0]);
				int vertex2 = Integer.parseInt(edgeData[1]);

				matrix[vertex1][vertex2] = matrix[vertex2][vertex1] = 1;
			}

			Q1260 m = new Q1260(numOfVertex, matrix);
			m.dfs(startVertex);
			m.reset();
			System.out.println();
			m.bfs(startVertex);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

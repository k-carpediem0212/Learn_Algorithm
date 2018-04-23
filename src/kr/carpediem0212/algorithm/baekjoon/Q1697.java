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
 *	------------------------------------------------
 *	조건 :
 *	------------------------------------------------
 *	
 *	최단 거리이므로 BFS를 이용하였다.
 *
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q1697 {
	private int[] map;
	private int coordinateOfSubin;
	private int coordinateOfSister;

	public Q1697(int coordinateOfSubin, int coordinateOfSister) {
		this.coordinateOfSubin = coordinateOfSubin;
		this.coordinateOfSister = coordinateOfSister;
		this.map = new int[100001];
	}

	public int seek() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(coordinateOfSubin);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == coordinateOfSister) {
				return map[current];
			}

			if ((current - 1) >= 0 && map[current - 1] == 0 && (current - 1) != coordinateOfSubin) {
				map[current - 1] = map[current] + 1;
				queue.offer(current - 1);
			}

			if ((current + 1) < 100001 && map[current + 1] == 0 && (current + 1) != coordinateOfSubin) {
				map[current + 1] = map[current] + 1;
				queue.offer(current + 1);
			}

			if ((current * 2) < 100001 && map[current * 2] == 0 && (current * 2) != coordinateOfSubin) {
				map[current * 2] = map[current] + 1;
				queue.offer(current * 2);
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");

			int coordinateOfSubin = Integer.parseInt(inputDatas[0]);
			int coordinateOfSister = Integer.parseInt(inputDatas[1]);

			Q1697 m = new Q1697(coordinateOfSubin, coordinateOfSister);
			System.out.println(m.seek());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
 *  **********************************************************
 *
 *   Written By k-carpediem0212 (k.carpediem0212@gmail.com)
 *   
 *  **********************************************************
 *
 *	------------------------------------------------
 *	조건 :
 *		모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다.
 *		즉, 집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.
 *	------------------------------------------------
 *	
 *	1. 첫번째 집이 빨강일 경우 
 *  2. 첫번째 집이 초록일 경우    
 *	3. 첫번째 집이 파랑일 경우 
 *	
 *  ---------------------------
 *  공간복잡도 : O(n)
 *  시간복잡도 : 
 *  ---------------------------
 */
public class Main {
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;
	private int[][] cost;
	private int[][] cache;
	
	public Main(int[][] cost) {
		this.cost = cost;
		this.cache = new int[3][cost[0].length];
		cache[0][0] = cost[0][0];
		cache[1][0] = cost[1][0];
		cache[2][0] = cost[2][0];
		
		for(int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(cost[i]));
		}
		
		System.out.println(calculate());
	}
	
	public int calculate() {
		System.out.println(cost[0].length);
		for(int i = 1; i < cost[0].length; i++) {
			int previewHouse = i - 1;
			cache[R][i] = cost[R][i] + Integer.min(cache[G][previewHouse], cache[B][previewHouse]);
			cache[G][i] = cost[G][i] + Integer.min(cache[R][previewHouse], cache[B][previewHouse]);
			cache[B][i] = cost[B][i] + Integer.min(cache[R][previewHouse], cache[G][previewHouse]);
		}
		
		return Integer.min(cache[cost[0].length - 1][0], Integer.max(cache[cost[0].length - 1][1], cache[cost[0].length - 1][2]));
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfHouse = Integer.parseInt(br.readLine().trim());
			int cost[][] = new int[numOfHouse][numOfHouse];

			for (int i = 0; i < numOfHouse; i++) {
				String[] inputDatas = br.readLine().trim().split("\\s+");

				for (int j = 0; j < 3; j++) {
					cost[j][i] = Integer.parseInt(inputDatas[j]);
				}
			}
			
			Main m = new Main(cost);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

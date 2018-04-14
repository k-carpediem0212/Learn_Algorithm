package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
 *	CASE 1. i번째 집이 빨강일 경우  => 이전 집이 파랑, 초록 중 최소 비용의 색으로 칠한다.
 *  CASE 2. i번째 집이 초록일 경우  => 이전 집이 빨강, 파랑 중 최소 비용의 색으로 칠한다.  
 *	CASE 3. i번째 집이 파랑일 경우  => 이전 집이 초록, 빨강 중 최소 비용의 색으로 칠한다.
 *	
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n)
 *  ---------------------------
 */
public class Q1149 {
	//편의를 위해 색에 상수를 지정
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;
	private int[][] cost;
	private int[][] cache;
	private int numOfHouse;
	
	public Q1149(int[][] cost, int numOfHouse) {
		this.cost = cost;
		this.numOfHouse = numOfHouse;
		this.cache = new int[3][cost[0].length];

		// 첫 집값을 cache에 초기화
		cache[0][0] = cost[0][0];
		cache[1][0] = cost[1][0];
		cache[2][0] = cost[2][0];
	}
	
	public int getMinCostOfPaint() {
		for(int i = 1; i < cost[0].length; i++) {
			int indexOfPreHouse = i - 1;
			//CASE 1
			cache[R][i] = cost[R][i] + Integer.min(cache[G][indexOfPreHouse], cache[B][indexOfPreHouse]);
			//CASE 2
			cache[G][i] = cost[G][i] + Integer.min(cache[R][indexOfPreHouse], cache[B][indexOfPreHouse]);
			//CASE 3
			cache[B][i] = cost[B][i] + Integer.min(cache[R][indexOfPreHouse], cache[G][indexOfPreHouse]);
		}
		
		int indexOfLastHouse = numOfHouse - 1;
		return Integer.min(cache[0][indexOfLastHouse], Integer.min(cache[1][indexOfLastHouse], cache[2][indexOfLastHouse]));
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfHouse = Integer.parseInt(br.readLine().trim());
			int cost[][] = new int[numOfHouse][numOfHouse];

			for (int i = 0; i < numOfHouse; i++) {
				String[] inputDatas = br.readLine().trim().split("\\s+");

				// cache와 동일하기 하기 위해 row를 색, column을 house로 Matrix 생성
				for (int j = 0; j < 3; j++) {
					cost[j][i] = Integer.parseInt(inputDatas[j]);
				}
			}
			
			Q1149 m = new Q1149(cost, numOfHouse);
			
			System.out.println(m.getMinCostOfPaint());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

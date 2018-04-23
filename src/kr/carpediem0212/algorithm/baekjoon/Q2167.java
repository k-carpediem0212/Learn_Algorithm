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
 *	------------------------------------------------
 *	이 문제는 처음에 완전 탐색으로 해결하였다가
 *	DP로 변경하였다.
 *
 *	최초 cache[][] 배열을 구성하는데 O(n^2)의 시간이 소요되며,
 *	이후 부분합을 계산하는데는 O(1)이 소요된다.
 *
 *	부분합은 
 *	
 *	아래의 점화식을 이용하여 계산한다.
 *		cache[i][j] = matrix[i][j] + (cache[i - 1][j] + cache[i][j - 1] - cache[i-1][j-1]);
 *
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q2167 {
	private int n;
	private int m;
	private int[][] matrix;
	private int cache[][];
	
	public Q2167(int n, int m, int[][] matrix) {
		this.n = n;
		this.m = m;
		this.matrix = matrix;
		
		this.cache = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				cache[i][j] = matrix[i][j] + (cache[i - 1][j] + cache[i][j - 1] - cache[i-1][j-1]);
			}
		}
	}
	
	// 완전 탐색을 이용한 계산
	public int subSum(int fromY, int fromX, int toY, int toX) {
		if(fromY == toY && fromX == toX) {
			return matrix[fromY - 1][fromX - 1];
		}
		
		int sum = 0;
		for(int i = (fromY - 1); i < toY; i++) {
			for(int j = (fromX - 1); j < toX; j++) {
				sum += matrix[i][j];
			}
		}
		
		return sum;
	}
	
	//DP를 이용한 계산
	public int subSumDP(int fromY, int fromX, int toY, int toX) {
		return cache[toY][toX] - cache[toY][fromX - 1] - cache[fromY - 1][toX] + cache[fromY - 1][fromX - 1];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] inputDatas = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(inputDatas[0]);
			int m = Integer.parseInt(inputDatas[1]);
			
			int[][] matrix = new int[n + 1][m + 1];
			for(int i = 1; i <= n; i++) {
				String[] rowDatas = br.readLine().trim().split("\\s+");
				for(int j = 1; j <= m; j++) {
					matrix[i][j] = Integer.parseInt(rowDatas[j - 1]); 
				}
			}
				
			Q2167 _m = new Q2167(n,m, matrix);
			
			int numOfSubSum = Integer.parseInt(br.readLine().trim());
			
			for(int i = 0; i < numOfSubSum; i++) {
				String[] subSumDatas = br.readLine().trim().split("\\s+");
				int fromY = Integer.parseInt(subSumDatas[0]);
				int fromX = Integer.parseInt(subSumDatas[1]);
				int toY = Integer.parseInt(subSumDatas[2]);
				int toX = Integer.parseInt(subSumDatas[3]);
				
				System.out.println(_m.subSumDP(fromY, fromX, toY, toX));
				//System.out.println(_m.subSum(fromY, fromX, toY, toX));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 
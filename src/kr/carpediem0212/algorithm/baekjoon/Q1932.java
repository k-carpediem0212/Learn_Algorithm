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
 *		수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
 *	------------------------------------------------
 *
 *	Dp를 위에서 아래로 구현하게되면, 양끝의 처리를 따로 해주어야 한다.
 *  하지만, 아래에서 위로 올라오면 i와 i+1은 항상 존재 하므로 더 간편하게 처리가 가능하다.
 *  
 *  도출된 점화식은 아래와 같다.
 *  	[i][j] = [i][j] + Integer.max([i+1][j], [i+1][j+1]);
 *  
 *  위 점화식을 아래에서 위로 반복한 후 최 상단 값([0][0])을 출력하면 된다.
 *  
 *  ---------------------------
 *  공간복잡도 : O(n^2)
 *  시간복잡도 : O(n^2)
 *  ---------------------------
 */
public class Q1932 {
	private int[][] triangle;
	private int[][] cache;
	private int width;
	
	public Q1932(int[][] triangle, int width) {
		this.triangle = triangle;
		this.cache = new int[width][width];
		this.width = width;
		
		//맨 마지막 줄은 동일하게 초기화
		cache[width-1] = triangle[width - 1];
	}
	
	public int maxDistance() {
		for(int i = (width - 2); i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				cache[i][j] = triangle[i][j] + Integer.max(cache[i+1][j], cache[i+1][j+1]); 
			}
		}

		return cache[0][0];
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int width = Integer.parseInt(br.readLine().trim());
			int[][] triangle = new int[width][width];
			
			for(int i = 0; i < width; i++) {
				String[] inputDatas = br.readLine().trim().split("\\s+");
				for(int j = 0; j < inputDatas.length; j++) {
					triangle[i][j] = Integer.parseInt(inputDatas[j]);
				}
			}
			
			Q1932 m = new Q1932(triangle, width);
			System.out.println(m.maxDistance());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

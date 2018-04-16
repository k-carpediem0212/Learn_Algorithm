package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	private int[][] triangle;
	private int[][] cache;
	private int width;
	
	public Main(int[][] triangle, int width) {
		this.triangle = triangle;
		this.cache = new int[width][width];
		this.width = width;
		
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
			
			Main m = new Main(triangle, width);
			System.out.println(m.maxDistance());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

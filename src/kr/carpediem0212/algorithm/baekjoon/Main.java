package kr.carpediem0212.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int T;
	public static int K;
	public static int[] numOfChapter;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			while ((T--) > 0) {
				st = new StringTokenizer(br.readLine());
				K = Integer.parseInt(st.nextToken());
				numOfChapter = new int[K];
				PriorityQueue<Integer> queue = new PriorityQueue();
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < K; i++) {
					queue.add(Integer.parseInt(st.nextToken()));	
				}
				
				int total = 0;
				while(queue.size() > 1) {
					int temp = queue.poll() + queue.poll();
					queue.offer(temp);
					total += temp;
				}
				
				System.out.println(queue.size() + "."+total);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

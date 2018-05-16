package kr.carpediem0212.algorithm.basic;

import java.util.Arrays;

public class QuickSort {
	public void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	public int partition(int[] arr, int begin, int end) {
		int pivot = begin;
		// 중간 인덱스를 pivot으로 잡기 위해
		swap(arr, (begin + end) / 2, begin);
		
		++begin;
		while (begin < end) {
			while((arr[begin] <= arr[pivot]) && begin < end) {
				begin++;
			}
			
			while((arr[end] > arr[pivot]) && begin <= end) {
				end--;
			}
			
			if(begin < end) {
				swap(arr, begin, end);
			}
		}
		
		swap(arr, pivot, end);

		return end;
	}
	
	public void swap(int[] arr, int num1, int num2) {
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}

	public static void main(String[] args) {
		QuickSort q = new QuickSort();

		int[] inputDatas = { 9, 2, 1, 6, 5, 8, 9, 2, 1 };
		q.quickSort(inputDatas, 0, inputDatas.length - 1);
		System.out.println(Arrays.toString(inputDatas));
	}
}

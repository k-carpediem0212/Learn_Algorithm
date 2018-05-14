package kr.carpediem0212.algorithm.basic;

import java.util.Arrays;

public class QuickSort {
	public void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			System.out.println("pivot : " + pivot);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	public int partition(int[] arr, int begin, int end) {
		int left = begin;
		int right = end;
		
		int pivot = (right + left) / 2;
		
		while(left < right) {
			while((arr[left] < arr[pivot]) && (left < right)) {
				left++;
			}
			
			while((arr[right] >= arr[pivot]) && (left < right)) {
				right--;
			}
			
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		
		int temp = arr[right];
		arr[right] = arr[pivot];
		arr[pivot] = temp;
		pivot = right;
		
		System.out.println(Arrays.toString(arr));
		return pivot;
	}

	public static void main(String[] args) {
		QuickSort q = new QuickSort();

		int[] inputDatas = { 9, 8, 5, 2, 3, 1, 4, 6, 7 };
		q.quickSort(inputDatas, 0, inputDatas.length - 1);
	}
}

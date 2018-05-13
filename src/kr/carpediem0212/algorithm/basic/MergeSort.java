package kr.carpediem0212.algorithm.basic;

import java.util.Arrays;

public class MergeSort {
	public void mergeSort(int[] data, int left, int right) {
		if (left < right) {
			int middle = (left + right) >> 1;
			mergeSort(data, left, middle);
			mergeSort(data, middle + 1, right);
			merge(data,left,middle,right);
		}
	}

	public void merge(int[] data, int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int[] temp = new int[data.length];	// left, right 병합을 위한 임시 배열

		int k = left;
		while (i <= middle && j <= right) {
			if (data[i] < data[j]) {
				temp[k++] = data[i++];
			} else {
				temp[k++] = data[j++];
			}
		}

		// right 정렬은 끝나고 left 요소가 남은 경우
		while (i <= middle) {
			temp[k++] = data[i++];
		}

		// left 정렬은 끝나고 right 요소가 남은 경우
		while (j <= right) {
			temp[k++] = data[j++];
		}

		// merge
		for (i = left; i <= right; i++) {
			data[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		MergeSort m = new MergeSort();

		int[] inputDatas = { 9, 8, 5, 2, 3, 1, 4, 6, 7 };
		m.mergeSort(inputDatas, 0, inputDatas.length - 1);
		System.out.println(Arrays.toString(inputDatas));
	}
}

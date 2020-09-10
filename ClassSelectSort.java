package codingLecture;

public class ClassSelectSort {
	
	private static void selectionSort(int[] arr) {
		// 배열과 시작 인텍스를 넣어 재귀함수를 호출한다.
		selectionSort(arr, 0);
	}
	
	private static void selectionSort(int[] arr, int start) {
		// 시작점이 배열의 마지막 방보다 작을 때 재귀함수를 호출합니다.
		if(start < arr.length - 1) {
			int min_index = start;
			// 가장 작은 방에 인덱스를 저장할 변수 선언 후
			// 초기값으로 시작 인덱스를 넣는다. 
			
			// 기준값보다 작은 값을 찾았을 때
			// min_index 변경
			for (int i = start; i < arr.length; i++) {
				if(arr[i] < arr[min_index]) {
					min_index = i;
				}
			}
			// 맨앞에 있는 것과 가장 작은 값을 바꾼다. 
			swap(arr, start, min_index);
			// 맨앞은 정렬이 완료되었기에 재귀함수를 다시 호출해서
			// 시작점 다음 배열부터 다시 정렬시킨다.
			selectionSort(arr, start + 1);
		}
	}
	
	// 두 개의 값 위치를 바꾸는 메서드
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {41, 21, 37, 24, 3};
		printArray(arr);
		selectionSort(arr);
		printArray(arr);

	}

}

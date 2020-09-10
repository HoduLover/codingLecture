package codingLecture;

public class ClassBubbleSort {
	
	private static void bubbleSort(int[] arr) {
		// 배열에 정렬이 안된 마지막 인덱스를 파라로 넘긴다
		// 처음에는 배열의 마지막 인덱스를 넘겨주면 된다
		bubbleSort(arr, arr.length - 1);
	}
	
	private static void bubbleSort(int[] arr, int last) {
		// 마지막 인덱스가 0보다 클때까지 호출을 한다
		if(last > 0) {
			// 1번 인덱스부터 마지막 인덱스까지 돌린다
			for (int i = 1; i <= last; i++) {
				// 앞에 있는 배열값이 기준값보다 크면 자리를 바꾼다
				if(arr[i - 1] > arr[i]) {
					swap(arr, i -1, i);
				}
			}
			// for문을 돌리고 난 뒤에는 
			// 정렬이 된 맨 마지막 인덱스는 빼고 정렬한다.
			bubbleSort(arr, last - 1);
		}
	}
	
	// 두 개의 값 위치를 바꾸는 메서드
	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
	
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 2, 1};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);

	}

}

package codingLecture;

public class ClassQuickSort {
	
	// quickSort라는 메서드를 선언해준다.
	private static void quickSort(int[] arr) {
		
		// 시작지점과 끝지점을 받는 재귀함수를 호출한다.
		quickSort(arr, 0, arr.length - 1);
	}
	
	// 시작지점과 끝지점을 인자로 받는 메서드를 오버라이드한다.
	// 파티션을 나눌 range 역할을 int 인자로 받는다.
	private static void quickSort(int[] arr, int start, int end) {
		// 오른쪽 방 첫 번째 값을 받아온다.
		int part2 = partition(arr, start, end);
		
		// 오른쪽 파티션이 시작점 바로 다음에서 시작한다면
		// 왼쪽 파티션의 데이터가 하나이기에 정렬을 할 필요가 없다. 
		// 오른쪽 파티션이 시작점에서 1개 이상 차이가 날때만 
		// 밑의 재귀 함수를 써서 그쪽 파티션에서 다시 정렬을 시도한다
		if(start < part2 - 1) {
			// 오른쪽 파티션에 시작점 바로 전으로 조정해서 함수 호출
			quickSort(arr, start, part2 - 1);
		}
		
		// 오른쪽 파티션에 배열 방이 1개 이상일 때만 호출을 해야하기에
		// 오른쪽 파티션의 시작점이 마지막 배열 방보다 작은 경우에만 
		// 오른쪽 파티션을 정렬하도록 한다.
		if(part2 < end) {
			// 오른쪽 파티션 시작값에서 start, 처음 range의 끝값을 end로 넣음
			quickSort(arr, part2, end);
		}
	}
	
	// 배열 방에 파티션을 나누는 함수(배열방 주소, 파이션 시작과 끝 값의 인덱스)
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) /2];
		// 피벗 값은 배열의 중간값
		// 시작점이 끝지점보다 작거나 같을 때만 반복적으로
		// 양쪽 끝에서 포인트를 한 칸씩 앞으로 옮긴다.
		while(start <= end) {
			// 스타트 포인트부터 배열방의 값이 기준값보다 작을 때만 
			// start 포인터가 뒤쪽츠로 움직인다.
			while(arr[start] < pivot) {
				start++;
			}
			// 그게 아니라 배열 방의 값이 기준 값보다 크거나 같으면 
			// end 포인터가 앞쪽으로 움직인다
			while(arr[end] > pivot) {
				end--;
			}
			
			// 시작점과 끝점이 서로 만났다가 지나치지 않았는지 확인 후
			if(start <= end) {
				// 두 개의 값을 바꾼다.
				swap(arr, start, end);
				// 포인터를 그대로 이동시킨다.
				start++;
				end--;
			}
		}
		// 위를 반복하다보면 
		// 새로 나눌 오른쪽 파티션의 첫번째 방 인덱스를 반환하게 된다.
		return start;
		
	}
	
	// 두 개의 값을 바꾸는 메서드
	private static void swap(int[] arr, int start, int end) {
		// 임시 데이터 tmp에 바꿀 값을 저장하고
		int tmp = arr[start];
		// 값을 바꾼 후에
		arr[start] = arr[end];
		// tmp값을 뒤로 보낸다
		arr[end] = tmp;
	}
	
	// 배열 확인용 메서드
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}

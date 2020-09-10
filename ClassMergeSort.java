package codingLecture;

public class ClassMergeSort {
	private static void mergeSort(int[] arr) {
		// 배열의 크기만큼 임시 저장소를 생성한다. 
		int[] tmp = new int[arr.length];
		// 배열과 임시 저장소, 시작과 끝 인덱스를 보내준다
		mergeSort(arr, tmp, 0, arr.length -1);
		
	}
	
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		// 시작 인덱스가 끝인덱스보다 작은 동안 진행하는데
		if(start < end) {
			// 가운데를 잘라야해서 가운데 변수가 필요하다.
			int mid = (start + end) / 2;
			// 배열의 앞부분과
			mergeSort(arr, tmp, start, mid);
			// 배열의 뒷부분을 각각 정렬
			mergeSort(arr, tmp, mid + 1, end);
			// 두개로 나뉜 배열 방을 병합한다. 
			merge(arr, tmp, start, mid, end);
		}
	}
	
	// 두개의 값을 병합하는 메서드
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		// 임시저장소에 기존의 배열을 복사한다. 
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		// 첫번째 방의 첫 번째 인덱스(포인터)와
		int part1 = start;
		// 두번째 방의 첫 번째 인덱스(포인터)를 변수에 담고
		int part2 = mid + 1;
		// 복사 후 다음 숫자가 들어갈 인덱스를 저장
		int index  = start;
		
		// 첫번째 배열과 두번째 배열이 끝까지 갈때까지 반복문을 돌린다
		while(part1 <= mid && part2 <=end) {
			// 첫 번째 방 값이 더 작을 때는
			if(tmp[part1] <= tmp[part2]) {
				// part1의 값을 옮기고
				arr[index] = tmp[part1];
				// part1의 포인터도 옮긴다.
				part1++;
			} else {
				// 두 번째 방도 마찬가지
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		// 앞쪽 포인터에 배열이 남았을 경우에
		// 남은 값들을 붙여준다
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
	
	// 확인용
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}

}

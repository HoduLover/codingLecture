package codingLecture;

public class ClassRecursive {
	
	// 2. 동적 계획법
	static long[] fibo;
	final static int idx = 50;
	
	public static void main(String[] args) {
		// 1. 재귀적 호출
		// System.out.println(fibonacci(idx));
		
		//2. 동적 계획법
		fibo = new long[idx + 1];
		System.out.println(fibonacci(idx));
	}

	public static long fibonacci(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		// 1. 재귀적 호출
		// return fibonacci(n - 1) + fibonacci(n - 2);
		
		// 2. 동적계산법
		if(fibo[n] != 0) {
			// 배열 값이 0이 아니라는 건 이미 계산이 됐다는 것
			return fibo[n];
		}
		
		fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return fibo[n];
	}

}

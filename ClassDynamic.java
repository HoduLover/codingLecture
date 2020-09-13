package codingLecture;

public class ClassDynamic {
	
	// 최소 비용을 확인하는 메서드를 생성
	// 계단별 비용이 들어간 배열을 인자로 받는다
	public static int minCostClimbingStairs(int[] cost) {
		// 계단을 돌때마다 생기는 두가지 경우의 수
		// 그리고 현재 계단의 수를 변수로 선언한다
		int case1 = 0;
		int case2 = 0;
		int current;
		
		// 뒤에서부터 확인을 하면서
		for (int i = cost.length -1; i >= 0; --i) {
			// 현재 값은 지금의 값과 앞의 두 경우의 최솟값을 합한 거다.
			current = cost[i] + Math.min(case1, case2);
			// 다음을 위해서 값을 다시 셋팅한다. 
			// 두 번째 멀리있는 것은 첫번째와 같고
			case2 = case1;
			// 첫 번째 멀리있는 것은 지금 현재의 것과 같다
			case1 = current;
		}
		// 두 개의 경우 중에서 작은 것을 반환하면 된다.  
		return Math.min(case1, case2);
	}
	public static void main(String[] args) {
		int[] cost = {1,2,3,4,5,6,7};
		int result = minCostClimbingStairs(cost);
		System.out.println(result);

	}

}

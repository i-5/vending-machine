
public class SubArraySum {

	int[] numbers = {-5,7,3,-7,-2,7,6,8,-3};
	int[] numbersSearch = {7,28,34,13,2,6,48,-3,4,66,1,123,89,90};
	int startIndex = 0;
	int endIndex = 0;
	int currentBiggestSum = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int seek = 66;
		
		// TODO Auto-generated method stub
		SubArraySum as = new SubArraySum();
		//as.sumSubArray();
		//System.out.println("SubArray start index: " + as.startIndex);
		//System.out.println("SubArray end index: " + as.endIndex);
		System.out.println("Binary search for " + seek + " at index: " + as.binarySearch(seek));
	}
	
	public int binarySearch(int seek) {
		int bot = -1;
		int top = numbersSearch.length;
		while (top - bot > 1) {
			int mid = (top + bot) / 2;
			if (numbersSearch[mid] < seek) bot = mid;
			else top = mid;
		}
		return bot;
	}
	
	public void sumSubArray() {
		int currentSum = 0;
		int head = 0;
		int tail = 0;
		int tmp = 0;
		for( int i = 0; i < numbers.length; i++) {
			currentSum += numbers[i];
			if (currentSum > currentBiggestSum ) {
				currentBiggestSum = currentSum;
				head = tmp;
				tail = i;
			}
			if( currentSum <= 0) {
				currentSum = 0;
				tmp = i + 1;
			}
		}
		startIndex = head;
		endIndex = tail;
	}

}

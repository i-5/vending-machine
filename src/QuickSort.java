import java.io.*;

public class QuickSort {
	
	int[] numbers = {12,9,4,99,120,1,3,10,13};
	int currentPivotIndex; 
	
	public QuickSort() {
	}

	public static void main(String[] args) {
		String strPivot = null;
	
		QuickSort qs = new QuickSort();
		System.out.println("List before sorting:");
		qs.printList();
		System.out.println("Please pick the pivot");
		BufferedReader choosen = new BufferedReader(new InputStreamReader(System.in));
		try {
			strPivot = choosen.readLine();	
		} catch (IOException e) {
			System.out.println("Error in reading input.");
			System.exit(1);
		}
		
		int pivot = Integer.parseInt(strPivot);
		qs.setPivotPosition(pivot);
		qs.quickSort(pivot, 0, qs.numbers.length - 1);
		while (!qs.allSorted()) {
			int index = qs.getPivotPosition();
			qs.quickSort(qs.numbers[0], 0, index); 
			qs.quickSort(qs.numbers[qs.numbers.length - 1], index+1, qs.numbers.length - 1); 
			qs.printList();
		}
		System.out.println("List after sorting:");
		qs.printList();
	}
	
	private int findPivotPosition(int pivot) {
		int i;
		for (i = 0; i < numbers.length; i++) {
			if (numbers[i] == pivot) {
				break;
			}
		}
		return i;
	}
	
	public int getPivotPosition() {
		return currentPivotIndex;
	}
	
	public void setPivotPosition(int pivot) {
		currentPivotIndex = findPivotPosition(pivot);
	}
	
	public void printList() {
		System.out.println("-------------------------");
		for (int i = 0; i < numbers.length; i++) 
			System.out.println(numbers[i] + ", ");
	}
	
	public boolean rightSideOK(int pivot) {
		for (int k = currentPivotIndex; k < numbers.length; ++k) {  
			if (numbers[currentPivotIndex] > numbers[k]) 
				return false;
		}
		return true;
	}
	
	public boolean leftSideOK(int pivot) {
		for (int k = currentPivotIndex; k >= 0; --k) {  
			if (numbers[currentPivotIndex] < numbers[k]) 
				return false;
		}
		return true;
	}
		
	public void quickSort(int pivot, int listStart, int listEnd) {
		currentPivotIndex = findPivotPosition(pivot);
		quickSortLeft(pivot, listStart, listEnd);
		printList();
		System.out.println("After left sort, pivot is:" + pivot);
		quickSortRight(pivot, listEnd, listStart);
		printList();
		System.out.println("After right sort, pivot is:" + pivot);
		if (!(leftSideOK(pivot) && rightSideOK(pivot)))
			quickSort(pivot, listStart, listEnd);	
	}
	
	private boolean allSorted() {
		int j = 1;
		for (int i = 0; i <= numbers.length-1; i++) {
			if (numbers[i] > numbers[j])
				return false;
			j++;
		}
		return true;
	}
	
	private void quickSortLeft(int pivot, int listStart, int listEnd) {
		for (int i = listStart; i <= listEnd; i++) {
			if (numbers[i] > pivot) {
				System.out.println("Found left greater number:" + numbers[i] + " at " + i + " Current pivot index is: " + currentPivotIndex);
				numbers[currentPivotIndex] = numbers[i];
				numbers[i] = pivot;
				currentPivotIndex = i;
				break;
			}
		}
	}
	
	private void quickSortRight(int pivot, int listStart, int listEnd) {
		for (int j = listStart; j >= listEnd; j--) {
			if (numbers[j] < pivot) {
				System.out.println("Found right lesser number:" + numbers[j] + " at " + j + " Current pivot index is: " + currentPivotIndex);
				numbers[currentPivotIndex] = numbers[j];
				numbers[j] = pivot;
				currentPivotIndex = j;
				break;
			}
		}
	}
	
}

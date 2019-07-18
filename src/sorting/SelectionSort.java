package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {2,1,8,3,6,5,4};
		int[] result = performSelectionSrot(arr);
		for(int i=0; i< result.length; i++) {
			System.out.print(result[i]+ ", ");
		}
	}

	private static int[] performSelectionSrot(int[] arr) {
		
		int length = arr.length;
		
		for(int i = 0; i < length - 2; i++) {
			int iMin = i;
			for(int j = i + 1; j < length; j++) {
				if(arr[j] < arr[iMin]) {
					iMin = j;
				}
			}
			int temp = arr[iMin];
			arr[iMin] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}

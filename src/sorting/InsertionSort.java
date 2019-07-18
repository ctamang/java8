package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 8, 3, 6, 5, 4 };
		int[] result = performInsertionSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}

	private static int[] performInsertionSort(int[] arr) {
		
		int length = arr.length;
		for(int i=1; i<length ;i++) {
			int value = arr[i];
			int holePosition = i;
			while(holePosition > 0 && arr[holePosition - 1] > value) {
				arr[holePosition]=arr[holePosition-1];
				holePosition = holePosition - 1;
			}
			arr[holePosition] = value;
		}
		return arr;
	}
	
}

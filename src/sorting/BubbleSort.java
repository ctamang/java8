package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 8, 3, 6, 5, 4 };
		int[] result = performBubbleSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}

	private static int[] performBubbleSort(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length; i++) {
			int flag = 0;
			for(int j=0; j< length-i-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0) {
				break;
			}
		}
		return arr;
	}
}

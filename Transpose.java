public class Transpose {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 4 }, { 2, 4, 3 }, { 3, 4, 5 }, { 1, 2, 3 } };

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {

				System.out.print(arr[j][i] + " ");
			}

			System.out.println();

		}

	}

}
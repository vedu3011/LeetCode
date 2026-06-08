package potd;
public class PartitionAccordingToPivot {

	public static int[] pivotArray(int[] nums, int pivot) {
		int n = nums.length;
		int[] result = new int[n];

		int idx = 0;

		// Elements less than pivot
		for (int num : nums) {
			if (num < pivot) {
				result[idx++] = num;
			}
		}

		// Elements equal to pivot
		for (int num : nums) {
			if (num == pivot) {
				result[idx++] = num;
			}
		}

		// Elements greater than pivot
		for (int num : nums) {
			if (num > pivot) {
				result[idx++] = num;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
		int pivot = 10;

		int[] result = pivotArray(nums, pivot);

		System.out.print("Result: ");
		for (int num : result) {
			System.out.print(num + " ");
		}
	}
}
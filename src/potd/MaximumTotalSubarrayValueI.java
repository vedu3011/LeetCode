package potd;

public class MaximumTotalSubarrayValueI {

    public static long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return 1L * k * (max - min);
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 1};
        int k = 3;

        long result = maxTotalValue(nums, k);

        System.out.println("Maximum Total Value: " + result);
    }
}
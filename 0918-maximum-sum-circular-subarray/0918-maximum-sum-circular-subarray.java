class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int currentMax = 0;
        int maxSum = nums[0];

        int currentMin = 0;
        int minSum = nums[0];

        for (int x : nums) {
            // Maximum normal subarray
            currentMax = Math.max(x, currentMax + x);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray
            currentMin = Math.min(x, currentMin + x);
            minSum = Math.min(minSum, currentMin);

            total += x;
        }

        
        if (maxSum < 0) {
            return maxSum;
        }

       
        return Math.max(maxSum, total - minSum);
    }
}
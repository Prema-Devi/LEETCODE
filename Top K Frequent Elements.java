import java.util.Arrays;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] uniqueNums = new int[n];
        int[] frequencies = new int[n];
        int uniqueCount = 0;
        int currentCount = 1;
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[i] != nums[i - 1]) {
                uniqueNums[uniqueCount] = nums[i - 1];
                frequencies[uniqueCount] = currentCount;
                uniqueCount++;
                currentCount = 1;
            } else {
                currentCount++; 
            }
        }
        int[] res = new int[k];
        for (int step = 0; step < k; step++) {
            int maxFreq = -1;
            int maxIndex = -1;
            for (int i = 0; i < uniqueCount; i++) {
                if (frequencies[i] > maxFreq) {
                    maxFreq = frequencies[i];
                    maxIndex = i;
                }
            }
            res[step] = uniqueNums[maxIndex];
            frequencies[maxIndex] = -1; 
        }
        
        return res;
    }
}

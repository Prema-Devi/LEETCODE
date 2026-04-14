class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min=nums[0] , max= nums[0];
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]<min)
            min = nums[i];
            if(nums[i]>max)
            max = nums[i];
        }//finding the minimum and maximum 
        if((max-min)-(2*k)<=0 || max-min==0)
        return 0;
        else
        return (max-min)-(2*k);
    }
}

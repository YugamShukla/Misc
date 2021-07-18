class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,h=nums.length -1;
        if(h+1==1 || nums[0]>=nums[1]) return 0;
        if(nums[h]>=nums[h-1]) return h;
        while(l<=h){
            int m=(l+h)/2;
            System.out.println(l+ " " + m + " " + h);
            if(m==0 || m==h) return -1;
            if (nums[m]>=nums[m-1] && nums[m]>=nums[m+1])
                return nums[m];
            else if (nums[m]>=nums[m-1])
                l=m;
            else if (nums[m]>nums[m+1])
                h=m;
            else
                l=m+1;
        }
        return -1;
    }
}


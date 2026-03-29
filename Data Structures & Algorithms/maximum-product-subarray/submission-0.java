class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int leftP= 1, rightP = 1;
        int n = nums.length;

        for(int i =0;i<n;i++){
            leftP = leftP == 0? 1 : leftP;
            rightP = rightP == 0? 1 : rightP;

            leftP *= nums[i];
            rightP*=nums[n-1-i];

            ans = Math.max(ans, Math.max(rightP, leftP));
        }
        return ans;
    }
}

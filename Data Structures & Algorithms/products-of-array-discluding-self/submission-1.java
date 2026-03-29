class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1, zerocount  = 0;
        int res[] = new int [nums.length];
        for(int n : nums){
            if(n==0) zerocount++;
            else total *= n;
        }

        for(int i = 0;i< nums.length;i++){
            if(zerocount>1) res[i]=0;
            else if(zerocount == 1) res[i] = (nums[i] == 0)?total :0;
            else res[i] = total/nums[i];
        }
        return res;
    }
}  

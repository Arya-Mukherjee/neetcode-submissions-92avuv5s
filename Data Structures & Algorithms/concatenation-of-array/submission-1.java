class Solution {
    public int[] getConcatenation(int[] nums) {
        int con[] = new int[2*nums.length];
        for(int i = 0;i<nums.length;i++){
            con[i]=nums[i];
            con[i+nums.length] = nums[i];
        }
        return con;
    }
}
class Solution {
    public int maxArea(int[] heights) {
        if(heights.length <2) return 0;
        int n  = heights.length;
        int left= 0;
        int right=n-1; 
        int maxArea = Integer.MIN_VALUE;
        while(left<right){
            int width = right - left;
            int area = width * (Math.min(heights[left], heights[right]));
            maxArea = Math.max(maxArea, area);
            if(heights[left] <heights[right]) left++;
            else right--;
        }
        return maxArea;
    }
}

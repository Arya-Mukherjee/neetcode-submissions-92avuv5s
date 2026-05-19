class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length -1, trapped = Integer.MIN_VALUE;
        while(left<right){
            if(heights[left]<heights[right]){
                trapped = Math.max(trapped, heights[left] * (right-left));
                left++;
            }
            else if(heights[left]>heights[right]){
                trapped = Math.max(trapped, heights[right] * (right-left));
                right--;
            }
            else{
                trapped = Math.max(trapped, heights[right] * (right-left));
                left++;right--;
            }
        }
        return trapped;
    }
}

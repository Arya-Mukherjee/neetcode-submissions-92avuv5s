class Solution {
    static int[] prevSmall(int arr[]) {
        int n = arr.length;
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();
            st.push(i);
        }
        return pse;
    }
    static int[] nextSmall(int arr[]) {
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();
            st.push(i);
        }
        return nse;
    }
    public int largestRectangleArea(int[] heights) {
        int[] pse = prevSmall(heights);
        int[] nse = nextSmall(heights);
        int maxArea = 0;
        for(int  i = 0;i<heights.length;i++){
            int area = heights[i] * (nse[i] - pse[i] -1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

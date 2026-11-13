class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        int last[] = new int[256];
        Arrays.fill(last, -1);
        for(int right = 0; right<s.length();right++){
            char c = s.charAt(right);
            if(last[c]>=left)
                left = last[c] + 1;
            last[c] = right;
            maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }
}
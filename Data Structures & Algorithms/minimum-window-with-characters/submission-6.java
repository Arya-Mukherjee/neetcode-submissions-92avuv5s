class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || s.length()<t.length()) return "";
        HashMap<Character, Integer> need = new HashMap<>();
        for(char c:t.toCharArray())
            need.put(c, need.getOrDefault(c,0)+1);
        int needCount = need.size();
        int have = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right<s.length();right++){
            char r = s.charAt(right);
            window.put(r, window.getOrDefault(r, 0)+1);
            if(need.containsKey(r) && window.get(r).intValue()==need.get(r).intValue())
                have++;
            
            while(have == needCount){
                if(right - left +1<minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char l = s.charAt(left);
                window.put(l, window.get(l)-1);
                if(need.containsKey(l) && window.get(l) < need.get(l))
                    have--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);
    }
}

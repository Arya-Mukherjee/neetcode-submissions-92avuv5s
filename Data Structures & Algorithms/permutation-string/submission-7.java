class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int window = s1.length();
        int c1[] = new int[26];
        int c2[] = new int[26];
        for(char c : s1.toCharArray())
            c1[c - 'a']++;
        for(int i = 0;i<window;i++)
            c2[s2.charAt(i) - 'a']++;

        if(matches(c1,c2)) return true;

        for(int i = window;i<s2.length();i++){
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i-window)- 'a']--;

            if(matches(c1,c2)) return true;
        }
        return false;
    }

    static boolean matches(int a[], int b[]){
        for(int i = 0;i<26;i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}

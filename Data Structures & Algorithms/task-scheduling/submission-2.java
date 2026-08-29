

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int maxCount = 1;

        for (int i = 24; i >= 0 && freq[i] == maxFreq; i--) {
            maxCount++;
        }

        return Math.max(
            tasks.length,
            (maxFreq - 1) * (n + 1) + maxCount
        );
    }
}
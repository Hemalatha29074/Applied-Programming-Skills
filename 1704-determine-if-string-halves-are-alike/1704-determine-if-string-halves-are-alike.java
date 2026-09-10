class Solution {
    public boolean halvesAreAlike(String s) {
        int count1 = 0, count2 = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i)))
                count1++;
        }

        for (int i = n / 2; i < n; i++) {
            if (isVowel(s.charAt(i)))
                count2++;
        }

        return count1 == count2;
    }

    boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
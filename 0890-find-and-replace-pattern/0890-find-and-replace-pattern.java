import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';

            if (map1[w] == -1 && map2[p] == -1) {
                map1[w] = p;
                map2[p] = w;
            } else if (map1[w] != p || map2[p] != w) {
                return false;
            }
        }

        return true;
    }
}
package Go2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//e c e b a
//^     ^
//  ^   ^
//    ^ ^
//    ^   ^
public class LongestSubstringWithAtMostTwoDistinctCharacters159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> characterSet = new HashMap<>();
        int j = 0;
        characterSet.put(s.charAt(j), 1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() - 1 &&
                    (characterSet.size() < 2 || (characterSet.size() == 2 && characterSet.containsKey(s.charAt(j + 1))))) {
                j++;
                characterSet.put(s.charAt(j), characterSet.getOrDefault(s.charAt(j), 0) + 1);
            }
            System.out.println(i + " " + j + " " + (j - i + 1));
            System.out.println(characterSet);
            maxLen = Math.max(maxLen, j - i + 1);
            characterSet.put(s.charAt(i), characterSet.get(s.charAt(i)) - 1);
            if (characterSet.get(s.charAt(i)) == 0) {
                characterSet.remove(s.charAt(i));
            }
        }

        return maxLen;
    }
}

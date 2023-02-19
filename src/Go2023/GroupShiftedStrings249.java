package Go2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>();

        for (String s : strings) {
            String hash = getHash(s);
            if (!keyToAnagrams.containsKey(hash)) {
                keyToAnagrams.put(hash, new ArrayList<>());
            }
            keyToAnagrams.get(hash).add(s);
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> list : keyToAnagrams.values()) {
            ans.add(list);
        }

        return ans;
    }

    //bcd -> abc
    //xyz -> abc
    static String getHash(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int distance = s.charAt(0) - 'a';
        StringBuilder hash = new StringBuilder();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)(arr[i] - 'a');
        }

        for (char c : arr) {
            hash.append((char)(((c - distance + 26) % 26) + 'a'));
        }

        return hash.toString();
    }


    static String getHash2(String s) {
        StringBuilder hash = new StringBuilder();
        char[] arr = s.toCharArray();

        int dist = 'z' - arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)(arr[i] - 'a');
        }


        for (int i = 0; i < arr.length; i++) {
            hash.append((char)((arr[i] + dist) % 26 + 'a'));
        }
        return hash.toString();
    }

    public static void main(String[] args) {
        System.out.println((int)'z');
        System.out.println(getHash2("abc"));
        System.out.println(getHash2("def"));
        System.out.println(getHash2("az"));
        System.out.println(getHash2("ba"));
        System.out.println('z' - 'a');
    }
}

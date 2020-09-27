package leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author mengxijie
 * @since 2020/9/24 8:52 下午
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        int max = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.getOrDefault(c, -1);
            map.put(c, i);
            tmp =
                    max = Math.max(max, i - tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring("abba"));
    }
}

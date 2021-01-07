package string;

public class LongestCommonPrefix {

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length <= 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length <= 0) return "";
        int min = Integer.MAX_VALUE;

        for (String str : strs) {
            if (str.isEmpty()) {
                return "";
            }
            min = Math.min(min, str.length());
        }

        String res = "";
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return res;
                }
            }
            res = res.concat(String.valueOf(c));
        }
        return res;
    }
}

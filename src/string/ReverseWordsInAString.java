package string;

public class ReverseWordsInAString {

    public String reverseWords1(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();

        reverseString(ss, 0, n);

        int start = 0, end;
        while (start < n) {

            while (start < n && ss[start] == ' ') start++;
            end = start;

            while (end < n && ss[end] != ' ') end++;

            if (end <= n) reverseString(ss, start, end);

            while (end < n && ss[end] == ' ') end++;

            start = end;
        }

        String res = String.valueOf(ss);
        res = res.replaceAll("\\s+", " ");
        if (res.startsWith(" ")) res = res.substring(1);
        if (res.endsWith(" ")) res = res.substring(0, res.length() - 1);

        return res;
    }

    public void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[end - 1];
            s[end - 1] = s[start];
            s[start] = tmp;
            start++;
            end--;
        }
    }
}

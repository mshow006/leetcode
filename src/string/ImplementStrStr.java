package string;

public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        // ImplementStrStr strStr = new ImplementStrStr();
        // System.out.println(strStr.strStr(haystack, needle));
        // System.out.println(haystack.indexOf(needle));

        byte[] value = haystack.getBytes();
        byte[] str = needle.getBytes();
        System.out.println(indexOf(value, value.length, str, str.length, 0));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int h = haystack.length();
        int n = needle.length();
        if (h == n && h == 0) return 0;
        for (int i = 0; i <= h - n; i++) {
            int j = 0;
            while (j < n && i < h && haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            }
            if (j == n) {
                return i - n;
            }
            i -= j;
        }
        return -1;
    }

    public static int indexOf(byte[] value, int valueCount, byte[] str, int strCount, int fromIndex) {
        byte first = str[0];
        int max = (valueCount - strCount);
        for (int i = fromIndex; i <= max; i++) {
            // Look for first character.
            if (value[i] != first) {
                while (++i <= max && value[i] != first);
            }
            // Found first character, now look at the rest of value
            if (i <= max) {
                int j = i + 1;
                int end = j + strCount - 1;
                for (int k = 1; j < end && value[j] == str[k]; j++, k++);
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
    }
}

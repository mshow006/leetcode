package string;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString string = new ReverseString();
        string.reverseString("the sky is blue".toCharArray());
        String s = "the sky is blue";
        s = String.valueOf(string.reverseString(s.toCharArray()));
        System.out.println(s);
    }

    public char[] reverseString(char[] s) {
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
        System.out.println(Arrays.toString(s));
        return s;
    }
}

package string;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null) return -1;
        int[] arr = new int[200];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}

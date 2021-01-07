package string;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        int[] arr = new int[200];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}

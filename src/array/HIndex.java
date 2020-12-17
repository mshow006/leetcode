package array;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(4 << 10);
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        int i = n - 1;
        for (; i >= 0; i--) {
            if (citations[i] < n - i) {
                break;
            }
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 2;
            // if(citations[i] < n)
        }
        return citations[0] >= n ? n : n - i - 1;
    }
}

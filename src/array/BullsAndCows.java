package array;

import java.util.HashSet;
import java.util.Set;


public class BullsAndCows {
    // 哈希表
    // 第一遍遍历计算所有相同位置大小相同的个数，分别用大小为10的数组记录两个字符串每个数字出现的次数
    // 第二次遍历数组，相同的次数为对应位置的最小值。
    public static String getHint(String secret, String guess) {
        int a = 0, b = 0, n = secret.length();
        int[] ds = new int[10], dg = new int[10];
        for (int i = 0; i < n; i++) {
            int x = secret.charAt(i) - '0';
            int y = guess.charAt(i) - '0';
            if (x == y) {
                a++;
            } else {
                ds[i]++;
                dg[i]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(ds[i], dg[i]);
        }
        return a + "A" + b + "B";
    }

    // bad
    public String badGetHint(String secret, String guess) {
        int a = 0, b = 0;
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                a++;
                set1.add(i);
                set2.add(i);
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (set1.contains(i)) continue;
            for (int j = 0; j < arr2.length; j++) {
                if (set2.contains(j)) continue;
                if (arr1[i] == arr2[j]) {
                    b++;
                    set2.add(j);
                    break;
                }
            }
        }
        return a + "A" + b + "B";
    }
}

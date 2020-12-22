package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // sort
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int curmax = 1;
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] + 1 == nums[j + 1]) {
                    curmax++;
                } else if (nums[j] != nums[j + 1] && nums[j] != nums[j + 1]) {
                    max = Math.max(max, curmax);
                    curmax = 0;
                    break;
                }
            }
            max = Math.max(max, curmax);
        }
        return max;
    }

    // hashset
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
            if(!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}

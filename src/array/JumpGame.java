package array;

public class JumpGame {

    // 贪心
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int max = 0; // 当前可到达的最远距离
        for (int i = 0; i < n; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1; // 可后退的最远位置
        for (int i = nums.length - 1; i >= 0; i --) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

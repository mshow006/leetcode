package array;

public class JumpGameII {
    // 在 i ~ end 区间内，选择可以跳到最远位置的索引 maxPos
    public int jump(int[] nums) {
        int n = nums.length - 1;
        int end = 0;
        int maxPos = 0;
        int steps = 0;
        for (int i = 0; i < n; i ++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}

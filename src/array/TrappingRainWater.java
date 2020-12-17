package array;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {

    public int trap_3(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()] - height[top]);
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    // DP
    // max_l[i]: 从当前下标到左侧最大高度的高度差
    // max_r[i]: 从当前下标到右侧最大高度的高度差
    // 每次找到当前位置的最高水位 = (两侧最大高度的较小值) - (当前高度)
    public int trap_2(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] max_l = new int[n];
        int[] max_r = new int[n];
        max_l[0] = height[0];
        for (int i = 1; i < n; i++) {
            max_l[i] = Math.max(height[i], max_l[i - 1]);
        }
        max_r[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max_r[i] = Math.max(height[i], max_r[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            ans += Math.min(max_l[i], max_r[i]) - height[i];
        }

        return ans;
    }

    // Brute force
    // 每次找到当前位置的最高水位 = (两侧最大高度的较小值) - (当前高度)
    public int trap_1(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int max_l = 0, max_r = 0;
            for (int j = i; j >= 0; j--) {
                max_l = Math.max(max_l, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max_r = Math.max(max_r, height[j]);
            }
            ans += Math.min(max_l, max_r) - height[i];
        }
        return ans;
    }
}

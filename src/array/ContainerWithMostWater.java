package array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, x = r;
        int max = 0;
        while(l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * x);
            if(height[l] < height[r]) l++;
            else r--;
            x--;
        }
        return max;
    }
}
